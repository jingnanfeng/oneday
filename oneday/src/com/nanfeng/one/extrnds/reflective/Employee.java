package com.nanfeng.one.extrnds.reflective;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-25 16:19
 */
public class Employee {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Employee() {
    }

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        Class empClass = employee.getClass();
        System.out.println(empClass.getName());
    }

}
