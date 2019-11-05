package thinkInstance.current;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-09-04 9:23
 */
class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }


    @Override
    public String call() throws Exception {
        return "return of TaskWithResult"+ id;
    }

}
public class CallableDeom{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(result.get());
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }
}
