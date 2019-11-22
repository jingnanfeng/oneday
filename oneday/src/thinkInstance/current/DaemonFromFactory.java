package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-21 15:41
 */
public class DaemonFromFactory implements Runnable {
    @Override
    public void run() {
        try {
            while (true){
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " : " + this);
            }
        }catch (InterruptedException e){
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool(
                new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
