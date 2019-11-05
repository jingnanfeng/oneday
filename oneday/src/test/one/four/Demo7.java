package test.one.four;

import java.time.LocalDate;

public class Demo7 {

    public static void main(String[] args) {
        Employee1[] staff=new Employee1[3];

        staff[0]=new Employee1("Carl Cracker",75000,1987,12,15);
        staff[1]=new Employee1("Harry Hacker",50000,1989,10,1);
        staff[2]=new Employee1("Tony Tester",40000,1990,3,15);
        for(Employee1  e : staff)
            e.raiseSalary(5);
        for(Employee1  e  : staff)
            System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
    }

}

class Employee1{
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee1(String n,double s,int year,int month,int day) {
        name=n;
        salary=s;
        hireDay =LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise=salary*byPercent/100;
        salary += raise;
    }
}
