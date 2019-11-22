package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-19 16:49
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff(int countDown){
        this.countDown = countDown;
    }

    public LiftOff(){}

    public String status(){
        return "#" + id +"(" + (countDown > 0 ? countDown : "Liftoff") + ").";
    }
    @Override
    public void run() {
        while (countDown-- >0){
            System.out.print(status());
            System.out.println();
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        /*Thread thread = new Thread(launch);
        thread.start();*/
        launch.run();
        System.out.println("Waiting for liftOff");



    }
}
