package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 20:56
 */
public class AtomicityTest implements Runnable {

    private int i = 0;

    public int getValue(){
        return i;
    }

    private synchronized void eventIncrement(){
        i++;
        i++;
    }
    @Override
    public void run() {
        while (true){
            eventIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true){
            int val = at.getValue();
            if (val % 2 != 0){
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
