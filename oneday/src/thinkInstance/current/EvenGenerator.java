package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-27 11:12
 */
public class EvenGenerator extends InGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        try {
            Thread.sleep(100);
        }catch (Exception e){
            e.getMessage();
        }
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
