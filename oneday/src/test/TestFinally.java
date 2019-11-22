package test;

import com.nanfeng.exception.BusinessException;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-13 14:28
 */
public class TestFinally {

    public static int testA(){
        int a = 0;
        try {
            return a += 80;
        } finally {
            System.out.println("test");
            a = a+1;
            if (a > 25) {
                System.out.println("b>25, b = " + a);
            }
        }
    }

    public static int test1() {
        int b = 20;

        try {
            System.out.println("try block");
            return b += 80;
        }
        catch (Exception e) {
            System.out.println("catch block");
        }
        finally {
            System.out.println("finally block");
            if (b > 25) {
                System.out.println("b>25, b = " + b);
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int i = testA();
        System.out.println(i);
    }
}
