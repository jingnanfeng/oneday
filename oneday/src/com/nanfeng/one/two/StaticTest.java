package com.nanfeng.one.two;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-22 18:43
 */
public class StaticTest {


    public int setA(int c){
        c++;
        return c;
    }

    public void setEmp(Employees employees){

       employees.setId(5555);
    }

    public static void main(String[] args) {

        int a = 9;
        StaticTest ass = new StaticTest();
        int c = ass.setA(a);
        System.out.println(a);

        Employees employees2 = new Employees(6);

        ass.setEmp(employees2);

        System.out.println(employees2.getId());
    }


}

class Employees{

    private int id;

    public Employees(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setId(int s){
        this.id = s;
    }

}