package com.nanfeng.thread.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-08 14:06
 */
public class TestForkJoinPool {
}


class ForkJoin extends RecursiveTask<Long>{

    private long start;

    private long end;

    private static final long THURSHOLD = 0L;


    @Override
    protected Long compute() {
        return null;
    }
}