package jvmtest.errer;

/**
 * @author liutao
 * @Title 创建线程导致内存溢出
 * @Description
 * @date 2019-11-13 17:35
 */
public class TestStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        TestStackOOM testStackOOM = new TestStackOOM();
        testStackOOM.stackLeakByThread();
    }
}
