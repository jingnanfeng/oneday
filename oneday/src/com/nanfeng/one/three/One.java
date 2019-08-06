package com.nanfeng.one.three;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author nanfeng
 * @date 2019-03-12 21:34
 */
public class One {

    public static boolean server(){
        boolean reuslt = Math.random()<0.99;
        System.out.println(reuslt+",");
        return reuslt;
    }

    public static void main(String[] args) {
        while (server()){
            System.out.println("1");
        }
        System.out.println("2");
    }
    @Test
    public void test(){
        boolean b = Character.isLowerCase(0);
        System.out.println(b);
    }

    @Test
    public void test2(){
        int a = 0;
        int[] arr = new int[25];
        for (int i = 0; i < 25; i++) {
             a = (int)(Math.random()*100+1);
             arr[i] = a;
             if (i==0) {
                 continue;
             }else{
                 if (arr[i]>arr[i-1]){
                     System.out.println("大于");
                 }else if (arr[i]<arr[i-1]){
                     System.out.println("小于");
                 }else {
                     System.out.println("等于");
                 }

             }

        }

    }

    /**
     *打印一到一百的素数（只能被自己和1整除）
     */
    @Test
    public void test3() {
        flag:
        for(int i = 1;i<=100;i++){
            for(int j = 2;j<i;j++){
                if(i % j == 0){
                    continue flag;
                }

            }
            System.out.println(i);
        }
    }
    @Test
    public void test4(){
        Random random = new Random(47);
        for (int i= 0; i<100; i++){
            int c = random.nextInt(26)+'a';
            System.out.println((char)c+" , "+c+" : ");
            switch (c){
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.print("aa");
                    break;
                case 'y':
                case 'w':
                    System.out.print("bb");
                    break;
                    default:
                        System.out.print("cc");
            }
        }
    }


    @Test
    public void test6(){
        String a = "aaaaaaaaaaaaaa";
        int hash = 0;
        for (int i=0;i<a.length();i++){
            hash = 31 * hash + (int)(a.charAt(i));
        }
        System.out.println(hash);
    }

    @Test
    void test7(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++){
            list.add(i+"");
        }
        long startTime = System.currentTimeMillis();
        list.add(0,"ss");
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime));

    }
    @Test
    public void test8(){
        String str = "aa-bb-cc-dd";
        String[] strs = str.split("-");
        StringBuffer sb = new StringBuffer();
        for (String s : strs) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }
    @Test
    public void test9(){
        List<String> stringList = new ArrayList<>();
        stringList.add("11");
        List<String> list = new ArrayList<>();
        list.retainAll(stringList);
        System.out.println(list);
    }
    @Test
    public void test10(){
        Object obj = new Object();
        System.out.println(obj.hashCode());
        String str = "";
    }
}
