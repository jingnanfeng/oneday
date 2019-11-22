package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-21 17:55
 */
public class TestYield  implements  Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"执行");
        while (true){
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new TestYield());
        }
        executorService.shutdown();
    }
}
