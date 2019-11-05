package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description 死锁的问题
 * @date 2019-08-31 18:13
 */
public class TestDeadLock {

    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread(){
            public void run(){
                synchronized (sb1){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    sb1.append("a");
                    synchronized (sb2){
                        sb2.append("b");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
        new Thread(){
            public void run(){
                synchronized (sb2){
                    try {
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    sb1.append("c");
                    synchronized (sb1){
                        sb2.append("d");
                        System.out.println(sb1);
                        System.out.println(sb2);
                    }
                }
            }
        }.start();
    }
}
