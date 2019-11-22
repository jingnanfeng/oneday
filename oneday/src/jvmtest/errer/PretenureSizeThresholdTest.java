package jvmtest.errer;

/**
 * @author liutao
 * @Title 大对象直接进入老年代
 * @Description
 * @date 2019-11-15 23:11
 */
public class PretenureSizeThresholdTest {

    private static final int _1MB = 1024 * 1024;

    public static void testPretenureSizeThreshold(){
        byte[] allocation;

        allocation = new byte[5 * _1MB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
