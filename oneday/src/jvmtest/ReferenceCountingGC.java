package jvmtest;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-09 20:59
 */
public class ReferenceCountingGC {

    private static final int num = 1024*1024;

    /*private byte[] bigSize = new byte[2*num];*/

    public Object instance = null;


    public static void main(String[] args) {
        ReferenceCountingGC gc1 = new ReferenceCountingGC();
        ReferenceCountingGC gc2 = new ReferenceCountingGC();
        //对象之间相互引用
        gc1.instance = gc2;
        gc2.instance = gc1;

        gc1 = null;
        gc2 = null;

        System.gc();
    }
}
