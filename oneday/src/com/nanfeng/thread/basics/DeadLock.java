package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-31 18:27
 */

class A{

    public synchronized void foo(B b){
        b.last();
    }
    public synchronized void last(){

    }
}
class B{

    public synchronized void bar(A a){
        a.last();
    }
    public synchronized void last(){

    }

}

public class DeadLock implements Runnable {
    A a = new A();
    B b = new B();

    @Override
    public void run() {
        a.foo(b);
    }

    public void init(){
        b.bar(a);
    }
    public static void main(String[] args){
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}
