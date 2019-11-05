package thinkInstance.current.atomic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 21:46
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger integer = new AtomicInteger(0);
    public int getValue(){
        return integer.get();
    }

    private void eventIncrement(){
        integer.addAndGet(2);
    }
    @Override
    public void run() {
        while (true){
            eventIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService excu = Executors.newCachedThreadPool();
        AtomicIntegerTest ait = new AtomicIntegerTest();
        excu.execute(ait);
        while (true){
            int val = ait.getValue();
            if (val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
