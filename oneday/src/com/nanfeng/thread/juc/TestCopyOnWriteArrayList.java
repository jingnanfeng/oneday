package com.nanfeng.thread.juc;

import java.util.concurrent.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-02 22:10
 */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread();
        for (int i = 0; i < 10; i++) {
            new Thread(helloThread).start();
        }
    }
}

class HelloThread implements Runnable{

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("aa");
        }
    }
}
