package com.nanfeng.one.three;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-03-21 22:16
 */
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//String s = adcde;
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        Set<Character> setChar = new HashSet<>();
        int count =0,i=0,j=0;
        while (i < length && j < length ){
            if (!setChar.contains(s.charAt(j))){
                setChar.add(s.charAt(j++));
                count = j-i;
            }else {
                setChar.remove(s.charAt(i++));
            }
        }
        return count;
    }


    public static void main(String[] args) {
        String s =  "aabcdd";
        Solution3 solution3 = new Solution3();
       int a =  solution3.lengthOfLongestSubstring(s);
        System.out.println(a);
    }

}
