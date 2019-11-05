package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-27 10:44
 */
public class SynchorizedEvenGengerator extends InGenerator {

    private int currentEventValue = 0;


    @Override
    public synchronized int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchorizedEvenGengerator());
    }
}
