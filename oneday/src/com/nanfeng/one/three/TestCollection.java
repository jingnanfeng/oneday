package com.nanfeng.one.three;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-18 9:34
 */
public class TestCollection {
    @Test
    public void test1(){
        String[] strings = {"11","22","33"};
        List<String> stringList = new ArrayList<>();
        stringList.add("44");
        String[] strs = stringList.toArray(strings);
        System.out.println(Arrays.toString(strs));
    }
}
