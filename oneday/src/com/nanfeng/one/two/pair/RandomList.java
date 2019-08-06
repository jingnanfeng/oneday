package com.nanfeng.one.two.pair;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-25 10:29
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random random = new Random(47);
    public void add(T item){
        storage.add(item);
    }
    public T select(){
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : ("The braon dbsid sfsa").split(" ")){
            rs.add(s);
        }
        for (int i =0; i<4;i++){
            System.out.println(rs.select());
        }
    }
}
