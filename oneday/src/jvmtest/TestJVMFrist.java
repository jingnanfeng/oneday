package jvmtest;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-12 21:08
 */
public class TestJVMFrist {

    private static final int byteSize = 1024 * 1024;

    public static void main(String[] args) {
        byte[] bytes = new byte[40*byteSize];
        /*byte[] bytes2 = new byte[40*byteSize];*/
        System.gc();

    }

}
