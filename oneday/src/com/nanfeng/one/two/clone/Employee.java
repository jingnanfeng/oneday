package com.nanfeng.one.two.clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-26 14:59
 */
public class Employee implements Cloneable{

    private String name;

    private double salary;

    private Date hireDate;

    public Employee(String name ,double salary){
        this.name = name;
        this.salary = salary;
        hireDate = new Date();
    }

    public Employee clone() throws CloneNotSupportedException{

        Employee cloned = (Employee)super.clone();

        cloned.hireDate = (Date)hireDate.clone();
        return cloned;
    }

    public void setHireDate(int year,int month, int day){
        Date newHireDay = new GregorianCalendar(year,month-1,day).getTime();
        hireDate.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }
}
