package thinkInstance.current;

import java.util.concurrent.ThreadFactory;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-05 9:25
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        t.start();
        return t;
    }
}
