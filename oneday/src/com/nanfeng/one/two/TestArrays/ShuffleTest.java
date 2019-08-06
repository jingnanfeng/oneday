package com.nanfeng.one.two.TestArrays;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-18 18:41
 */
public class ShuffleTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0,6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);

        int i = Collections.binarySearch(numbers,5);
        System.out.println(i);

        Integer[] a = {1,2,3,4,5};
        List<Integer> integers = Arrays.asList(a);

        Object[] b =  integers.toArray();

    }

}
