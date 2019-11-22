package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-19 18:02
 */
public class SleepingTask extends LiftOff {

    @Override
    public void run(){
        try {
            while (countDown-- > 0){
                System.out.println(status());
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }catch (InterruptedException e){
            System.err.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();

    }

}
