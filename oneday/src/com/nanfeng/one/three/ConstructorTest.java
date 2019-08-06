package com.nanfeng.one.three;

import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 10:15
 */
public class ConstructorTest {

    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Harry",4000);
        staff[1] = new Employee(60000);
        staff[2] = new Employee();

        for (Employee employee :staff){
            System.out.println("name="+
                    employee.getName()+",id="+
                    employee.getId()+",salary="+
                    employee.getSalary());
        }
    }

}

class Employee{
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    static {
        Random gengerator = new Random();
        nextId = gengerator.nextInt(10000);
    }
    {
        id = nextId;
        nextId++;
    }
    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary){
        this("Employee #"+nextId,salary);
    }

    public Employee(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
