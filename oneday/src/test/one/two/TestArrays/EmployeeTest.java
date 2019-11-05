package test.one.two.TestArrays;

import java.util.Arrays;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-25 17:33
 */
public class EmployeeTest{
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];

        staff[0] = new Employee("harry",100);
        staff[1] = new Employee("bob",5000);
        staff[2] = new Employee("rat",200);
        Arrays.sort(staff);

        for (Employee employee : staff) {
            System.out.println("name="+employee.getName()+",salary="+employee.getSalary());
        }
    }
}

 class Employee implements Comparable<Employee>{

    private String name;
    private double salary;

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

     @Override
     public int compareTo(Employee o) {
         return Double.compare(salary,o.salary);
     }
 }
