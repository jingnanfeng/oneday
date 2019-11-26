package thinkInstance.current.generator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-26 15:51
 */
public class EvenGengerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public  int next() {
        ++ currentEvenValue;
        ++ currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGengerator());
    }
}
