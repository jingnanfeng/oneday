package com.nanfeng.one.extrnds.absatrct;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 17:21
 */
public abstract class Person {

    public abstract String getDescription();

    private String name;

    public  Person(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
