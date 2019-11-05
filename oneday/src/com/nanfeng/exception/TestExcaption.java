package com.nanfeng.exception;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-22 10:49
 */
public class TestExcaption {

    public static double testCount(){
        try {
            double b =  5/0;
            return b;
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        double v = testCount();
        System.out.println(v);
    }

}
