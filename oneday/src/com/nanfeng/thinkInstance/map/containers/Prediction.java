package com.nanfeng.thinkInstance.map.containers;

import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-03 11:45
 */
public class Prediction {

    private static Random rand = new Random(47);

    private boolean shadow = rand.nextDouble() > 0.5;

    public String toString(){
        if (shadow){
            return "Six more weeks of Winter!";
        }else {
            return "Early Spring";
        }
    }


}
