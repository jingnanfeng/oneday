package thinkInstance.current.generator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-26 16:25
 */
public class SynchronizedEvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    public synchronized int next(){
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
