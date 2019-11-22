package jvmtest.errer;

/**
 * @author liutao
 * @Title 长时间存活的对象进入老年代
 * @Description
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:SurvivorRatio=8
 * -XX:MaxTenuringThreshold=1 经历几次GC进入年老代
 * @date 2019-11-16 20:56
 */
public class TenuringThresholdTest {

    private static final int _1M = 1024 * 1024;

    public static void  testTenuringThreshold(){
        byte[] allocation1,allocation2,allocation3;

        allocation1 = new byte[_1M / 4];
        //什么时候进入老年代取决于XX:MaxTenuringThreshold设置
        allocation2 = new byte[4 * _1M];
        allocation3 = new byte[4 * _1M];
        allocation3 = null;
        allocation3 = new byte[4 * _1M];
    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
