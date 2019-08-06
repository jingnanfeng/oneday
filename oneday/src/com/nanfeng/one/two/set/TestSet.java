package com.nanfeng.one.two.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-17 11:46
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try(Scanner in = new Scanner(System.in))
        {
            while (in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext();i++){
            System.out.println(iter.next());
        }
        System.out.println("...");
        System.out.println(words.size() + "distinct words."+totalTime +"milliseconds");
    }
}
