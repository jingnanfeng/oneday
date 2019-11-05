package thinkInstance.current;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-27 16:53
 */
public class MutexEvenGengerator extends InGenerator {

    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenGengerator());
    }
}
