package thinkInstance.current;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-27 10:50
 */
public class EvenChecker implements Runnable {

    private InGenerator generator;

    private final int id;

    public EvenChecker(InGenerator generator, int id){
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
     while (!generator.isCanceled()){
         int val = generator.next();
         if (val % 2 != 0){
             System.out.println(val + " not enve!");
             generator.cancel();
         }
     }
    }

    public static void test(InGenerator gp,int count){
        System.out.println("Press Control-C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp,i));
        }
        exec.shutdown();

    }
    public static void  test(InGenerator gp){
        test(gp,10);
    }
}
