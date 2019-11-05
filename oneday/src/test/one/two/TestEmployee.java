package test.one.two;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-22 16:25
 */

import java.time.LocalDate;

/**
 * 写一个Employee类
 */
class Employee{

    private String name;
    private double salary;
    private LocalDate hireDay;

    private static int id;

    public int getId() {
        return id;
    }

    public void setId() {
        id ++;
    }

    public Employee() {
    }

    public String getName(){
        return name;
    }
}

public class TestEmployee {
    public static void main(String[] args) {
        Employee staff = new Employee();
        staff.setId();
        System.out.println(staff.getId());
        Employee staff2 = new Employee();
        staff2.setId();
        System.out.println(staff2.getId());
    }
}
