package com.nanfeng.thread.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-04 20:07
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket,"窗口一");
        Thread t2 = new Thread(ticket,"窗口二");
        Thread t3 = new Thread(ticket,"窗口三");
        t1.start();
        t2.start();
        t3.start();
    }

}

class Ticket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true){
            try {
                lock.lock();
                if (tick > 0){
                    System.out.println(Thread.currentThread().getName()+"买出一张票,余票为："+--tick);
                }
            }finally {
                lock.unlock();
            }

        }
    }
}