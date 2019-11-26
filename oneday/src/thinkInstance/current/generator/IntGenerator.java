package thinkInstance.current.generator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-26 15:17
 */
public abstract class IntGenerator {

    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel(){
        canceled = true;
    }

    public boolean isCanceled(){
        return canceled;
    }

}
