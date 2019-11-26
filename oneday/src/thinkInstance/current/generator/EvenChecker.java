package thinkInstance.current.generator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-26 15:23
 */
public class EvenChecker implements Runnable {

    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g,int ident){
        generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()){
            int val = generator.next();
            if (val % 2 != 0){
                System.out.println(val + "not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            System.out.println("线程"+i);
            executorService.execute(new EvenChecker(gp,i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator gp){
        test(gp,10);
    }
}
