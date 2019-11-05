package test.one.three;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 17:21
 */
public class TestData {

    @Test
    public void test(){
        int a = 1234566789;
        float b = a;
        System.out.println(b);
        double c = 1.23456792E8;
        int d = (int) c;
        System.out.println(d);
    }
    @Test
    public void test2(){
        double a = 12.569;
        int b = (int)a;
        double c = 12.359;
        int d = (int)Math.round(c);
        System.out.println(b+" "+d);
    }

    @Test
    public void test3(){
        int a = 7;
        int b = 7;
        int c = 7 * a++;
        int d = 7 * ++b;
        System.out.println(c+" "+d);
    }

    public static final Integer A = 9;
    @Test
    public void test4(){
        int a = 1>>>3;
        System.out.println(a);

        String v = String.join("/","c","d","e","f");
        System.out.println(v);
        System.out.println(A);
    }

    @Test
    public void test5(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一行数据:");
        String str = input.nextLine();
        System.out.println(str);
    }
}
