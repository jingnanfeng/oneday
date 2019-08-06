package com.nanfeng.one.extrnds.equals;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-24 11:53
 */
public class Employee {

    private String name;
    private double salary;
    private LocalDate hrieDay;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hrieDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
    public LocalDate getHrieDay(){
        return hrieDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent /100;
        salary +=raise;
    }
    @Override
    public boolean equals(Object otherObject){
        if (this == otherObject){
            return true;
        }
        if (otherObject == null){
            return false;
        }
        if (getClass() != otherObject.getClass()){
            return false;
        }
        Employee other = (Employee)otherObject;
        return Objects.equals(name,other.name)
                && salary == other.salary
                && Objects.equals(hrieDay,other.hrieDay);
    }

    @Override
    public int hashCode(){
        return Objects.hash(name,salary,hrieDay);
    }

    @Override
    public String toString(){
        return getClass().getName()+"[name=" +name+ ",salary=" +salary+
        ",hireDay=" + hrieDay+"]";
    }


}
