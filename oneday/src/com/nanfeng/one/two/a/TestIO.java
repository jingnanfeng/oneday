package com.nanfeng.one.two.a;

import java.io.File;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-16 10:36
 */
public class TestIO {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\aaa.txt");
            System.out.println( file.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
