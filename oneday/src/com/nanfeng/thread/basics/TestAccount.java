package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description 两个用户向同一个账户中存3000元，存三次，每次存完打印账户余额
 * @date 2019-08-31 16:32
 */

class Account{
    private double balance;

    //存钱
    public synchronized void dispoly(int amt){
        balance += amt;
        System.out.println(Thread.currentThread().getName() + "存1000元，当前余额为："+(balance));
    }
}

class Customer implements Runnable{

    private Account account = new Account();


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.dispoly(1000);
        }
    }
}

public class TestAccount {

    public static void main(String[] args) {
        Customer a = new Customer();

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);

        t1.start();
        t2.start();
    }


}
