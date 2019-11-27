package thinkInstance.current.atomicity;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-27 11:11
 */
public class SerialNumberGenerator {

    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber(){
        return serialNumber++;
    }
}
