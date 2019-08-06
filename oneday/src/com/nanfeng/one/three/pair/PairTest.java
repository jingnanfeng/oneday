package com.nanfeng.one.three.pair;
import com.nanfeng.one.extrnds.equals.Employee;

import java.time.LocalDate;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-02 15:58
 */
public class PairTest {
    public static void main(String[] args) {
        LocalDate[] localDates = {
                LocalDate.of(1906,12,9),
                LocalDate.of(1815,12,20),
                LocalDate.of(1903,12,3),
                LocalDate.of(1910,6,22),
        };
        Pair<LocalDate> mm = ArrayAlg.minmax(localDates);
        System.out.println("min "+mm.getFirst());
        System.out.println("max "+mm.getSecond());
        Pair<String> stringPair = new Pair<>();
        Pair<Employee> employeePair = new Pair<>();

        boolean b = stringPair.getClass().equals(employeePair.getClass());
        System.out.println(b);
    }




}
class ArrayAlg{
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if (a == null || a.length == 0){
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