package com.nanfeng.one.two.thread;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 12:00
 */
public class LockBank {

    private final double[] accounts;

    private Lock lock = new ReentrantLock();

    public LockBank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public void transfer(int from,int to,double amount){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d",amount,from,to);
            accounts[to] += amount;
            System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
        }finally {
            lock.unlock();
        }

    }
    public double getTotalBalance(){
        double sum = 0;
        for (double a : accounts){
            sum += a;
        }
        return sum;
    }

    public int size(){
        return accounts.length;
    }


}
