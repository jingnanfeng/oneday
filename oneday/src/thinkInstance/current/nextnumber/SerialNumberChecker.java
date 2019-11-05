package thinkInstance.current.nextnumber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 21:32
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;

    private static CircularSet set = new CircularSet(1000);

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable{

        @Override
        public void run() {
            while (true){
                //方法不同步
                int serial = SerialNumberGengerator.nextSerialNumber();
                if (set.contains(serial)){
                    System.out.println("Duplication: "+serial);
                    System.exit(0);
                }
                set.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new SerialChecker());
            if (args.length > 0){
                TimeUnit.SECONDS.sleep(new Integer(args[0]));
                System.out.println("no");
                System.exit(0);
            }
        }
    }
}
