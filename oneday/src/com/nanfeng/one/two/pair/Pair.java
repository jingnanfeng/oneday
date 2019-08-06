package com.nanfeng.one.two.pair;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-13 12:45
 */
public class Pair<T> {
    private T first;
    private T second;
    public Pair(){
        first = null;
        second = null;
    }

    public Pair(T first,T second){
        this.second = second;
        this.first = first;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
