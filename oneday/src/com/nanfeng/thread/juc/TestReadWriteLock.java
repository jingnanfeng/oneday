package com.nanfeng.thread.juc;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-05 21:18
 */
public class TestReadWriteLock {

    public static void main(String[] args) {

        ReadWriteLocaDemo rd = new ReadWriteLocaDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                rd.set(random.nextInt());
            }
        },"write").start();

        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    rd.get();
                }
            },"read").start();
        }
    }
}

class ReadWriteLocaDemo{
    private int number = 0;

    private ReadWriteLock lock = new ReentrantReadWriteLock();

    //读
    public void get(){
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+ " : " +number);
        }finally {
            lock.readLock().unlock();
        }

    }

    //写
    public void set(int number){
        lock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            lock.writeLock().unlock();
        }
    }
}
