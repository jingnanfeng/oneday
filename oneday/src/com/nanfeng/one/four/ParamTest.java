package com.nanfeng.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 9:10
 */
public class ParamTest {

    public static void tripValue(double x){
        x = 3 * x;
        System.out.println("End of method:x="+x);
    }

    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method:"+x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("Emd of method : x="+x.getName());
        System.out.println("End of method : y="+y.getName());
    }


    public static void main(String[] args) {
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent="+percent);
        tripValue(percent);
        System.out.println("After:="+percent);

        System.out.println("------------------------------");

        System.out.println("\nTesting tripleSalary:");
        Employee harry = new Employee("harry",2000);
        System.out.println("Before: salary="+harry.getSalary());
        tripleSalary(harry);
        System.out.println("After : salary="+harry.getSalary());

        System.out.println("---------------------------------");

        System.out.println("\nTesting swap:");
        Employee a = new Employee("Alice",3000);
        Employee b = new Employee("Bob",2000);
        System.out.println("Before: a="+a.getName());
        System.out.println("Before: b="+b.getName());
        swap(a,b);
        System.out.println("After: a="+a.getName());
        System.out.println("After: b="+b.getName());
    }

}

class Employee{
    private String name;
    private double salary;

    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

}