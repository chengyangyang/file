package com.zhnari.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.zhnari.bean.Role;
import com.zhnari.bean.User;
import com.zhnari.service.UserService;

public class AuthRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;
    
    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;//获取用户输入的token
        String username = utoken.getUsername();    
        List<User> findUserByUserName = userService.findUserByUserName(username);
          User user = findUserByUserName.get(0);
        	return new SimpleAuthenticationInfo(user, user.getuPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码  
        /*查出用户的所有信息*/
       // User user = userService.findUserByUserName(username);      
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        User user=(User) principal.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
       
        List<String> permissions=new ArrayList<>();
       
        List<String> rolename = new ArrayList<>();	
        
        List<User> selectRoleByName = userService.selectRoleByName(user.getuName());
        if(!selectRoleByName.isEmpty()){
        for (User user1 : selectRoleByName) {
				 Set<Role> roleSet = user1.getRoleSet();
				for (Role role : roleSet) {		
					rolename.add(role.getrName());	
					
				/*通过角色名称查询出角色的权限*/
					List<String> selectPermissionByName = userService.selectPermissionByName(role.getrName());		
					if(!selectPermissionByName.isEmpty()){
						for (String string : selectPermissionByName) {
		
							permissions.add(string);
						}		
					}			 
			}		
		 }	
        }
        
        
        //获得用户的权限,并放入到list集合中
        //Set<Role> roles = user.getRoles();
      //  if(roles.size()>0) {
       //     for(Role role : roles) {
      //          Set<Module> modules = role.getModules();
       //         if(modules.size()>0) {
       //             for(Module module : modules) {
       //                 permissions.add(module.getMname());
        //            }
         //       }
         //   }
       // }
              
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permissions);//将权限放入shiro中.
        return info;
    }
}