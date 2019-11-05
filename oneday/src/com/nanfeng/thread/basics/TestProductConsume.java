package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title 生产者消费者的问题
 * @Description
 * @date 2019-08-31 19:24
 */

/**
 * 店员
 */
class Clerk{
    int product;
    //生产产品
    public synchronized void addProcduct() throws Exception{
        if (product >= 20){
            wait();
        }else {
            product++;
            System.out.println(Thread.currentThread().getName()+":生产了第"+product+"产品");
            notifyAll();
        }
    }
    //消费产品
    public synchronized void deleteProduct() throws Exception{
        if (product <= 0){
            wait();
        }else {
            product--;
            System.out.println(Thread.currentThread().getName()+":消费了第"+product+"产品");
            notifyAll();
        }

    }
}

/**
 * 生产者
 */
class Producter implements Runnable{
    private Clerk clerk;

    public Producter(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true){
            try {
                Thread.sleep(100);
                clerk.addProcduct();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}

class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                clerk.deleteProduct();
            }catch (Exception e){
                e.getMessage();
            }
        }
    }
}

public class TestProductConsume {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();

        Producter p1 = new Producter(clerk);
        Consumer c1 = new Consumer(clerk);

        //生产者的线程
        Thread t1 = new Thread(p1,"生产者");
        //消费者的线程
        Thread t2 = new Thread(c1,"消费者");
        t1.start();
        t2.start();
    }

}
