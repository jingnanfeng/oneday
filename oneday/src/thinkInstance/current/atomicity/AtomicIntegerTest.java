package thinkInstance.current.atomicity;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-27 11:28
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger integer = new AtomicInteger(0);

    public int getValue(){
        return integer.get();
    }

    private void evenIncrement(){
        integer.addAndGet(2);
    }

    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.err.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        executorService.execute(ait);
        while (true){
            int value = ait.getValue();
            if (value % 2 != 0){
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
