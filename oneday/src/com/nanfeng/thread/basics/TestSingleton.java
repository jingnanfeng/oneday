package com.nanfeng.thread.basics;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-31 20:42
 */

class Singleton{
    //私有化构造器
    private Singleton(){}
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
                return instance;
            }
        }
        return null;
    }
}
public class TestSingleton {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
