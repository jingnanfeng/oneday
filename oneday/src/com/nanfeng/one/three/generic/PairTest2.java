package com.nanfeng.one.three.generic;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-06-11 12:09
 */
public class PairTest2 {

    public static void main(String[] args) {
        Employee[] a = {};
        Pair<Employee> mm = ArrayAlg2.minmax(a);
    }

}
class ArrayAlg2{

    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if (a == null || a.length ==0){
            return null;
        }
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }

}