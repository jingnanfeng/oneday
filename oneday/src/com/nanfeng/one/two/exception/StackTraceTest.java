package com.nanfeng.one.two.exception;

import java.util.Scanner;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-28 10:06
 */
public class StackTraceTest {

    public static int factorial(int n){
        System.out.println("factorial("+n+")");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement frame : frames) {
            System.out.println(frame);
        }
        int r;
        if (n <= 1){
            r = 1;
        }else {
            r = n * factorial(n-1);
        }
        System.out.println("return"+r);
        return r;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = input.nextInt();
        factorial(n);
    }
}
