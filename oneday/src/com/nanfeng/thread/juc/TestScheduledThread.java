package com.nanfeng.thread.juc;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-08 13:23
 */
public class TestScheduledThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            Future<Integer> schedule = scheduledExecutorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    return num;
                }
            }, 3, TimeUnit.SECONDS);
            System.out.println(schedule.get());
        }
        scheduledExecutorService.shutdown();

    }

}


