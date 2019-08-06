package com.nanfeng.one.two.string;

import java.util.Arrays;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-12 22:11
 */
public class Spitting {
    public static String kinghts = "then, when you have found the";

    public static void split(String regex){
        System.out.println(Arrays.toString(kinghts.split(regex)));
    }
    public static void main(String[] ages){
        split(" ");
        split("\\W+");
        split("n\\W+");
    }
}
