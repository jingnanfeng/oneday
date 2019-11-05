package thinkInstance.current.nextnumber;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 21:16
 */
public class SerialNumberGengerator {

    private static volatile int serialNumber = 0;

    public synchronized static int nextSerialNumber(){
        return serialNumber++;
    }

}
