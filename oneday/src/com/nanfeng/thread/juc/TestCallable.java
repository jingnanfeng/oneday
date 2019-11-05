package com.nanfeng.thread.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-02 22:39
 */
public class TestCallable {

    public static void main(String[] args) {
        TheadDemo2 td = new TheadDemo2();
        //执行Callable方式，需要FutureTask实现类的至此，用于接收运算结果的支持
        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();
        //接收线程运算后的结果
        try {
            Integer integer = result.get();
            System.out.println(integer);
        }catch (Exception e){
            e.getMessage();
        }

    }
}
class TheadDemo2 implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
