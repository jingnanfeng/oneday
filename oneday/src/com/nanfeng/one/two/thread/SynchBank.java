package com.nanfeng.one.two.thread;

import java.util.Arrays;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 15:43
 */
public class SynchBank {

    private int a = 0;

    public final double[] accounts;

    public SynchBank(int n,double initialBalance){
        accounts = new double[n];
        Arrays.fill(accounts,initialBalance);
    }

    public synchronized void transfer(int from,int to,double amount) throws InterruptedException{
        while (accounts[from] <amount){
            wait();
        }
        System.out.println(Thread.currentThread().getName());
        accounts[from] -= amount;
        System.out.printf("%10.2f from %d to %d",amount,from,to);
        accounts[to] += amount;
        System.out.println("-------------------------"+a++);
        System.out.printf("Total Balance : %10.2f%n",getTotalBalance());
    }

    public synchronized double getTotalBalance(){
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
