package thinkInstance.current.atomicity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-27 9:44
 */
public class AtomicityTest implements Runnable {

    private volatile int i = 0;

    public synchronized int getValue(){
        return i;
    }

    private synchronized void evenIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        executorService.execute(at);
        while (true){
            int value = at.getValue();
            if (value % 2 != 0){
                System.out.println(value);
                System.exit(0);
            }
        }
    }
}
