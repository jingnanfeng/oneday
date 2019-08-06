package com.nanfeng.one.extrnds.absatrct;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 17:23
 */
public class Employee extends Person{

    private double salary;
    private LocalDate hireDay;

    public Employee(String name,double salary,int year,int month,int day){
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year,month,day);
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    @Override
    public String getDescription() {
        return String.format("an employee with a salary of $%.2f",salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Double.compare(employee.getSalary(), getSalary()) == 0 &&
                Objects.equals(getHireDay(), employee.getHireDay());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSalary(), getHireDay());
    }
}
