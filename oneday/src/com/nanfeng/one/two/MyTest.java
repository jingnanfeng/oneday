package com.nanfeng.one.two;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-05 9:48
 */
public class MyTest {
    public static void main(String[] args) {

        Person person = new Student();
        System.out.println("-------------------------------------");
        person.run();
        Person.eat();
        System.out.println("-------------------------------------");
    }
}
