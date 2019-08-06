package com.nanfeng.one.two.pair;


/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-29 9:24
 */
public class PariTest {

    public static void main(String[] args) {

        Employee[] employees = {new Employee(1),new Employee(2)};

        Pair<Employee> pair =  ArrayAlg.min(employees);

        //String[]  words = {"Mary","had","a","tt"};


    }
}

class ArrayAlg{

    public static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) >0){
                min = a[i];
            }
            if (max.compareTo(a[i]) <0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }

    public static  <T extends Comparable> Pair<T> min(T[] a){
        if (a == null){
            return null;
        }
        T min = a[0];
        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }
        }
        return new Pair<T>();
    }

}
class Employee implements Comparable{
    private Integer id;

    public Employee(Integer id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
