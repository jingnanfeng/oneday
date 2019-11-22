package jvmtest.monitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-16 21:45
 */
public class MonitoringTest {

    static class OOMObject{
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //稍作延迟，令监视的曲线更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}
