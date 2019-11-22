package thinkInstance.current;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-21 15:49
 */
public class DaemonThreadPoolExcetor extends ThreadPoolExecutor {
    public DaemonThreadPoolExcetor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),new DaemonThreadFactory());
    }
}
