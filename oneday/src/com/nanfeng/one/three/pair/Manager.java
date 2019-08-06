package com.nanfeng.one.three.pair;

import com.nanfeng.one.extrnds.equals.Employee;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-03 15:01
 */
public class Manager extends Employee {

    private double bouns;

    public Manager(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
    }

    public Manager(String name, double salary, double bouns) {
        super(name, salary);
        this.bouns = bouns;
    }

    public double getBouns() {
        return bouns;
    }

    public void setBouns(double bouns) {
        this.bouns = bouns;
    }
}
