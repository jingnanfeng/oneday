package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-05 8:48
 */
public class SimplePriorities implements Runnable{

    private int countDown = 5;
    private volatile double d;
    private int priority;
    private String name;

    public SimplePriorities(int priority,String name){
        this.priority = priority;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return Thread.currentThread().getName()+":" +countDown;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true){
            for (int i = 0; i < 10000; i++) {
                d += (Math.PI + Math.E) /(double)i;
                if (i % 1000 == 0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY,"线程"+i));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY,"优先级最大线程"));
        exec.shutdown();
    }
}
