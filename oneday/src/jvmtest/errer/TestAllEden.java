package jvmtest.errer;

/**
 * @author liutao
 * @Title 对象优先在Eden分配
 * @Description
 * @date 2019-11-15 22:14
 */
public class TestAllEden {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] allocation1,allocation2,allocation3,allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
