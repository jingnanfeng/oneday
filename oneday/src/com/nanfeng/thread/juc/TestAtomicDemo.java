package com.nanfeng.thread.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-02 21:05
 */
public class TestAtomicDemo {
    public static void main(String[] args) {
        AtomicDemo ad = new AtomicDemo();

        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}

class AtomicDemo implements Runnable{

    //private volatile int serialNumber = 0;

    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.getMessage();
        }

        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }

}