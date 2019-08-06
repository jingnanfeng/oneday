package com.nanfeng.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-01 21:37
 */
public class TestIO {

    public String nextString()  {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String str ="" ;
       try {
            str =  br.readLine();
       }catch (IOException e){
           e.printStackTrace();
       }
       return str;
    }
    public int nextInt(){
        return Integer.parseInt(nextString());
    }

    public static void main(String[] args) {
        TestIO i = new TestIO();
        System.out.println("请输入一个字符串");
        String str = i.nextString();
        System.out.println(str);
    }

}
