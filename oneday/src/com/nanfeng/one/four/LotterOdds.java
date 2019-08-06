package com.nanfeng.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-15 18:21
 */

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 判断中将几率
 */
public class LotterOdds {
    public static void main(String[] args) {
       /* Scanner input = new Scanner(System.in);

        System.out.println("抽取的次数");
        int k = input.nextInt();

        System.out.println("总数");
        int n = input.nextInt();

        *//*
        * n*(n-1)*...(n-k+1)/(1*2*...*k)
        *//*

        BigInteger lotterOdds = BigInteger.valueOf(1);
        for (int i = 1; i <= k; i++){
            lotterOdds = lotterOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("几率为"+lotterOdds);*/

        BigInteger a = BigInteger.valueOf(100);

        BigInteger mod = a.mod(BigInteger.valueOf(20));
        System.out.println(mod);
    }
}
