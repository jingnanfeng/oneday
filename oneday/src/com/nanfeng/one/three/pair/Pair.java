package com.nanfeng.one.three.pair;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-06-10 15:15
 */
public class Pair<T> {

    private T first;
    private T second;

    public Pair(){
        first = null;
        second = null;
    }
    public Pair(T first, T second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }
    public T getSecond(){
        return second;
    }

    public void setFirst(T first){
        this.first = first;
    }
    public void setSecond(T second){
        this.second = second;
    }

}

