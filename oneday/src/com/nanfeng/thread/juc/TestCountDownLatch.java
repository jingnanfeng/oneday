package com.nanfeng.thread.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-02 22:22
 */
public class TestCountDownLatch {

    public static void main(String[] args) {

        final CountDownLatch latch = new CountDownLatch(10);
        long start = System.currentTimeMillis();
        LatchDeom latchDeom = new LatchDeom(latch);
        for (int i = 0; i < 10; i++) {
            new Thread(latchDeom).start();
        }
        try {
            latch.await();
        }catch (Exception e){
            e.getMessage();
        }
        long end = System.currentTimeMillis();

        System.out.println("花费时间为："+(end - start));
    }

}

class LatchDeom implements Runnable{

    private CountDownLatch latch;

    public LatchDeom(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i < 50000; i++) {
                    if (i % 100 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                latch.countDown();
            }
        }
    }
}