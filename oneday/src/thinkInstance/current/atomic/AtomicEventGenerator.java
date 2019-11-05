package thinkInstance.current.atomic;

import thinkInstance.current.EvenChecker;
import thinkInstance.current.InGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 22:34
 */
public class AtomicEventGenerator extends InGenerator {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int next() {
        return atomicInteger.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEventGenerator());
    }
}
