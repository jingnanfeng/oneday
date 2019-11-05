package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description 模拟火车站开三个窗口卖100票
 * @date 2019-08-31 12:24
 */

class Window extends Thread{

    static int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (Thread.class){
                if (ticket > 0){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println(currentThread().getName()+"售票：票号为："+ticket--);
                }else {
                    break;
                }
            }
        }
    }

    public Window(String name){
        super(name);
    }
}

public class TestWindow extends Thread{
    public static void main(String[] args) {
        Window t1 = new Window("窗口1");
        Window t2 = new Window("窗口2");
        Window t3 = new Window("窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
