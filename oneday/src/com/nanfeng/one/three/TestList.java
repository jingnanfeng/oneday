package com.nanfeng.one.three;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 15:33
 */
public class TestList {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("aa");
        stringList.add("aa");
        stringList.add("bb");
        stringList.add("bb");

        Stream<String> stringStream =  stringList.stream().distinct();



    }
}
