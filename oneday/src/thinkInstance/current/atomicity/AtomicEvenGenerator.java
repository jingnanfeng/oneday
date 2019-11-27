package thinkInstance.current.atomicity;

import thinkInstance.current.generator.EvenChecker;
import thinkInstance.current.generator.IntGenerator;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-27 11:43
 */
public class AtomicEvenGenerator extends IntGenerator {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public int next() {
        return atomicInteger.addAndGet(2);
    }

    public static void main(String[] args) {
        EvenChecker.test(new AtomicEvenGenerator());
    }
}
