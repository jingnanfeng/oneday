package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-19 17:04
 */
public class MoreBasicThreads {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
            System.out.println();
        }
        System.out.println("waiting for LiftOff");
    }

}
