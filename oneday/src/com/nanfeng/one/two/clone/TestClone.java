package com.nanfeng.one.two.clone;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-26 15:07
 */
public class TestClone {
    public static void main(String[] args)  {
        try {
            Employee original = new Employee("jone",2000);
            original.setHireDate(2000,1,1);
            Employee coye = original.clone();
            coye.raiseSalary(10);
            coye.setHireDate(2005,12,31);
            System.out.println("oraginal="+original);
            System.out.println("coye="+coye);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
    }
}
