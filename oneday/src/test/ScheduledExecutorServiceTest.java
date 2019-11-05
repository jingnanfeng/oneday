package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-16 11:59
 */
public class ScheduledExecutorServiceTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("run "+ System.currentTimeMillis());
            }
        }, 0, 10000, TimeUnit.MILLISECONDS);
    }
}
