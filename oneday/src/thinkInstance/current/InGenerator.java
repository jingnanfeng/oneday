package thinkInstance.current;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-27 10:46
 */
public abstract class InGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }
}
