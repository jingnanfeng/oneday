package com.nanfeng.one.extrnds;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 15:20
 */
public class Manager extends Employee{

    private double bonus;

    public Manager(String name,double salary,int year,int month,int day){
        super(name,salary,year,month,day);
        this.bonus = 0;
    }
    @Override
    public double getSalary(){
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
    public void setBonus(double b){
        bonus = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Manager)) {
            return false;
        }
        Manager manager = (Manager) o;
        return Double.compare(manager.bonus, bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonus);
    }

}
