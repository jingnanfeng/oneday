package com.nanfeng.one.three.pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-05 14:35
 */
public class ArrayTest {
    public static void main(String[] args) {
        Father[] fathers = new Son[]{};
        System.out.println(fathers.getClass());
        List<String> stringList = new MyList();
        System.out.println(stringList.toString().getClass());
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(7,1);
        list.remove(-2);
    }
}
class Father{}
class Son extends Father{}
class MyList extends ArrayList<String> {
    @Override
    public String[] toArray() {
        return new String[]{"1","2","3"};
    }
}