package jvmtest.errer;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-13 17:26
 */
public class TestStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        TestStackSOF stackSOF = new TestStackSOF();
        try {
            stackSOF.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:"+stackSOF.stackLength);
            throw e;
        }

    }

}
