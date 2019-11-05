package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title 线程通讯
 * @Description 使用两个线程打印1-100，线程1，线程2 交替打印
 * @date 2019-08-31 18:44
 */

class PrintNum implements Runnable{
    int num = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                if (num <= 100){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+":"+num);
                    num++;
                }else {
                    break;
                }
                try {
                    wait();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

public class TestCommunication {

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread t1 = new Thread(printNum,"甲");
        Thread t2 = new Thread(printNum,"乙");

        t1.start();
        t2.start();

    }

}
