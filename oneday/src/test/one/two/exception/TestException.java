package test.one.two.exception;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-26 16:54
 */
public class TestException extends RuntimeException{

    public TestException(String msg){
        super(msg);
    }

}
class Create{

    public int test(){
        int c = 0;
        try {
            int a = 9;
            int b = 0;
            c = a / b;
            return c;
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public static void main(String[] args) {
        Create create = new Create();
        create.test();
    }

}
