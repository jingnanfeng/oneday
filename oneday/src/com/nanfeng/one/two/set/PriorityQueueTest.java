package com.nanfeng.one.two.set;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-17 13:59
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815,12,10));
        pq.add(LocalDate.of(1903,12,13));
        pq.add(LocalDate.of(1910,6,22));
        System.out.println("Iterating over elements...");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        while (!pq.isEmpty()){
            System.out.println(pq.remove());
        }
    }
}
