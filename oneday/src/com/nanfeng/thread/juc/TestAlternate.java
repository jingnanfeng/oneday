package com.nanfeng.thread.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title ABC交替打印
 * @Description
 * @date 2019-09-05 20:49
 */
public class TestAlternate {
    public static void main(String[] args) {
        AlternateDemo ad = new AlternateDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
               while (true){
                    ad.loopA();

                }
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ad.loopB();

                }
            }
        },"B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ad.loopC();

                }
            }
        },"C").start();
    }


}

class AlternateDemo{

    /**
     * 当前执行线程的标价
     */
    private int number = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void loopA(){
        lock.lock();
        try {
            int totalLoop = 1;
            //判断
            if (number != 1){
                condition1.wait();
            }
            //打印
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+ i + "\t"+ totalLoop);
                totalLoop++;
            }
            //唤醒
            number = 2;
            condition2.signal();
        }catch (Exception e){
            e.getMessage();
        }finally {
            lock.unlock();
        }
    }

    public void loopB(){
        lock.lock();
        try {
            //判断
            int totalLoop = 1;
            if (number != 2){
                condition2.wait();
            }
            //打印
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+ i + "\t"+ totalLoop);
                 totalLoop ++;
            }
            //唤醒
            number = 3;
            condition3.signal();
        }catch (Exception e){
            e.getMessage();
        }finally {
            lock.unlock();
        }
    }

    public void loopC(){
        lock.lock();
        try {
            //判断
            int totalLoop = 1;
            if (number != 3){
                condition3.wait();
            }
            //打印
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+ i + "\t"+ totalLoop);
                totalLoop ++;
            }
            //唤醒
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.getMessage();
        }finally {
            lock.unlock();
        }
    }

}
