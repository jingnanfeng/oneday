package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-03 9:14
 */
public class ListOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public ListOff(){

    }

    public ListOff(int countDown){
        this.countDown = countDown;
    }

    public String status(){
        return "#" + id +"("+(countDown > 0 ?countDown :"listoff!")+"),";
    }

    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.print(status());
            Thread.yield();
        }
        System.out.println();
    }
}
