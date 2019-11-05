package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-31 15:12
 */

class Window2 implements Runnable{

    int ticket = 100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (ticket > 0){
                try {
                    Thread.sleep(100);
                }catch (Exception e){
                    e.printStackTrace();
                }
                    System.out.println(Thread.currentThread().getName() +"售票：票号为："+ticket--);
                }else {
                    break;
                }
            }
        }
    }
}

public class TestWindow2 {

    public static void main(String[] args) {
        Window1 w = new Window1();

        Thread t1 = new Thread(w,"窗口一");
        Thread t2 = new Thread(w,"窗口二");
        Thread t3 = new Thread(w,"窗口三");

        t1.start();
        t2.start();
        t3.start();
    }


}
