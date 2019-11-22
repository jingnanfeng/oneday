package jvmtest;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-12 21:58
 */
public class TestEscape {

    public static Object obj;

    public void variableEscape(){
        obj = new Object(); //发生逃逸
    }

    public Object methEscape(){
        return new Object();//方法逃逸
    }

    public static void allocc(){
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            allocc();
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);

    }

}
