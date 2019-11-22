package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-19 17:27
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
