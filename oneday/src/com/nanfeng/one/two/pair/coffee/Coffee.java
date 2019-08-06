package com.nanfeng.one.two.pair.coffee;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 9:30
 */
public class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }

}
