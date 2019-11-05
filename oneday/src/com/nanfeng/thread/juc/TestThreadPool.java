package com.nanfeng.thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-08 12:49
 */
public class TestThreadPool {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolDemo demo = new ThreadPoolDemo();
        //为线程池中的线程分配任务
        for (int i = 0; i < 10; i++) {
            executorService.submit(demo);
            System.out.println();
        }
        //关闭线程池
        executorService.shutdown();


    }

}

class ThreadPoolDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (i < 100){
                    System.out.print(Thread.currentThread().getName()+ ":"+ ++i);
                }
            }
        }
    }
}