package com.softi.bean;

import org.apache.ibatis.type.Alias;

@Alias("person")
public class Person {
   
    private Integer id;

    
    private String name;

   
    private Integer age;

    private Integer roles;

   
    public Integer getId() {
        return id;
    }

   
    public void setId(Integer id) {
        this.id = id;
    }

   
    public String getName() {
        return name;
    }

 
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

   
    public Integer getRoles() {
        return roles;
    }

    
    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}