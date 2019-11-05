package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-31 12:06
 */

class RrintNum extends Thread{
    public void run(){
        //需要子线程执行的代码
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +" : "+i);
            }
        }
    }
    public  RrintNum(String name){
        super(name);
    }
}
public class TestThread {
    public static void main(String[] args) {
        RrintNum r1 = new RrintNum("线程1");
        RrintNum r2 = new RrintNum("线程2");
        r1.setPriority(Thread.MAX_PRIORITY);//10
        r2.setPriority(Thread.MIN_PRIORITY);//1
        r1.start();
        r2.start();
    }
}
