package com.nanfeng.one.two.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 18:10
 */
public class MyTest {

    @Test
    public void test1(){
        int a = 0;
        AtomicInteger atomicInteger = new AtomicInteger();
        a = atomicInteger.incrementAndGet();
        System.out.println(a);
        AtomicLong atomicLong = new AtomicLong();


    }
}
