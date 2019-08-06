package com.nanfeng.one.extrnds.equals;

import java.util.ArrayList;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-24 11:52
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams",75000,1996,5,26);
        Employee alice2 = alice1;
        Employee alica3 = new Employee("Alice Adams",75000,1996,5,26);

        Employee bob = new Employee("bob",2000,2005,12,1);

        System.out.println("alice1 == alice2:"+(alice1 == alice2));

        System.out.println("alice1 == alice3:"+(alice1 == alica3));

        System.out.println("alice1.equals(alice3)："+(alice1.equals(alice2)));

        System.out.println("alice1.equals(bob):"+(alice1.equals(bob)));

        System.out.println("bob.toString:"+bob.toString());

        System.out.println("---------------------------------------------------");

        Manager car1 = new Manager("Car1",80000,2003,5,6);
        Manager boss = new Manager("Car1",80000,2003,5,6);
        boss.setBouns(5000);
        System.out.println("boss.toString():"+boss);
        System.out.println("car1.equals(boss):"+car1.equals(boss));
        System.out.println("alice1.hashCode()"+alice1.hashCode());
        System.out.println("alice3.hashCode()"+alica3.hashCode());
        System.out.println("bob.hashCode()"+bob.hashCode());
        System.out.println("car1.hashCode()"+car1.hashCode());


    }
}

