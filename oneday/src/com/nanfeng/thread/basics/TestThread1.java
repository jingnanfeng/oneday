package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description 通过实现Runable的方式创建多线程
 * @date 2019-08-31 14:53
 */

class PrintNum1 implements Runnable {
    @Override
    public void run() {
        //需要子线程执行的代码
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +" : "+i);
            }
        }
    }
}
public class TestThread1 {

    public static void main(String[] args) {
        PrintNum1 p = new PrintNum1();
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        t1.start();
        t2.start();
    }
}
