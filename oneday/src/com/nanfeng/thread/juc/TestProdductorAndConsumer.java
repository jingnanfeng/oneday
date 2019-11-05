package com.nanfeng.thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-04 20:17
 */
public class TestProdductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);

        ExecutorService exec = Executors.newCachedThreadPool();

        exec.execute(productor);
        exec.execute(consumer);
        exec.shutdown();

    /*    new Thread(productor,"生产者").start();
        new Thread(consumer,"消费者").start();*/
    }

}

class Clerk{
    private int product = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //进货
    public void get(){
        lock.lock();
        try {
            if (product >= 10){
                System.out.println("产品已满");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+ ++product);
            condition.signalAll();
        }catch (Exception e){
            e.getMessage();
        }finally {
            lock.unlock();
        }

    }
    //卖货
    public void sale(){
        lock.lock();
        try {
            if (product <= 0){
                System.out.println("缺货！");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+ --product);
            condition.signalAll();
        }catch (Exception e){
            e.getMessage();
        } finally {
            lock.unlock();
        }


    }
}

//生产者
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}
//消费者
class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            clerk.sale();
        }
    }
}


