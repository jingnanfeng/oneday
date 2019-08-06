package com.nanfeng.one.three.generic;


/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-06-11 12:16
 */
public class Employee implements Comparable<Employee> {
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Employee e) {
        return this.id-e.id;
    }
}
