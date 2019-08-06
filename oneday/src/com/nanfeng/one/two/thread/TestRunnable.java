package com.nanfeng.one.two.thread;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 17:44
 */
public class TestRunnable {

    public static void main(String[] args) {

        Runnable runnable = () -> {
            try {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100);
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        };

        new Thread(runnable).start();
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

