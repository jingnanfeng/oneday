package jvmtest.errer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-13 21:46
 */
public class TestDeadLock {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void deadLock(){
        new Thread(()->{
            synchronized (lock1){
                try {
                    System.out.println(Thread.currentThread().getName()+"得到lock1");
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println(Thread.currentThread().getName()+"得到lock2");
                }
            }
        },"线程1").start();

        new Thread(()->{
            synchronized (lock2){
                try {
                    System.out.println(Thread.currentThread().getName()+"得到锁2");
                    Thread.sleep(300);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println(Thread.currentThread().getName()+"得到锁1");
                }
            }
        },"线程2").start();

    }

    public void visualVM() throws InterruptedException{
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for (int j = 0; j < 1000; j++) {
            while (i<200000){
                i++;
                try {
                    Thread.sleep(100);
                    map.put(i,i);
                }catch (OutOfMemoryError e){
                    e.getStackTrace();
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws Throwable{
        TestDeadLock deadLock = new TestDeadLock();
        //deadLock.deadLock();
        deadLock.visualVM();

    }

}
