package com.nanfeng.one.two.thread;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-27 10:10
 */
public class DeadBank {

    private int accountsA;

    private int accountsB;

    private int money;


    public DeadBank(int accountsA ,int accountsB){
       this.accountsA = accountsA;
       this.accountsB = accountsB;
    }

    public synchronized void transB(int money){
        accountsA -= money;
        accountsB += money;
    }

    public synchronized  void transA(int money){
        accountsB -= money;
        accountsA += money;
    }

    public static void main(String[] args) {
        DeadBank deadBank = new DeadBank(200,300);

        Runnable r = () -> {
            deadBank.transB(100);
        };
        Thread thread = new Thread(r);
        thread.start();

        Runnable r2 = () -> {
          deadBank.transA(100);
        };
        Thread thread1 = new Thread(r2);
        thread.start();
    }
}
