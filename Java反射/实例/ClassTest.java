package com.ch.bean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

import org.junit.Test;

public class ClassTest {

	@Test
	public void classintext() throws Exception{
		try {
			Class<?> forName = Class.forName("com.ch.bean.Test");
			Field[] fields = forName.getFields();//得到公有的属性
			
			System.out.println("ssss"+fields[0].getName());
			Object instance = forName.newInstance();
			Method[] declaredMethods = forName.getDeclaredMethods();//得到公有的方法
			for(int i = 0;i < declaredMethods.length;i++){
				System.out.println(declaredMethods[i].getName());
			}
			forName.getName();//得到反射类的名称
			Constructor<?>[] constructors = forName.getConstructors();//得到构造方法
			Date date = new Date();
			
			declaredMethods[5].setAccessible(true);//取消访问私有方法的合法性检查 
			
			System.out.println(declaredMethods[5].invoke(forName.newInstance(), null));//执行方法
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
