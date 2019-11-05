package thinkInstance.current;

import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-05 9:14
 */
public class SimpleDaemons implements Runnable{


    @Override
    public void run() {
        try {
            while (true){
                //TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread()+" "+this);
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread demon = new Thread(new SimpleDaemons());
            demon.setDaemon(true);
            demon.start();
        }
        Thread.sleep(10000);
        System.out.println("aaaaaaaaaaaaaaa");
    }
}
