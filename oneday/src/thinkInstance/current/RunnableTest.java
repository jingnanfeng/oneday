package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-03 8:55
 */
public class RunnableTest {

    public static void main(String[] args) {
        RunbableDemo r = new RunbableDemo();
        for (int i = 0; i < 100; i++) {
            new Thread(r,"线程"+i).start();
        }
    }
}


class RunbableDemo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+" : "+i);
            Thread.yield();
        }
    }
}
