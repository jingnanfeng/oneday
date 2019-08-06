package com.nanfeng.one.two.pair;

/**
 * @author liutao
 * @Title 栈：先进后出
 * @Description
 * @date 2019-05-25 10:08
 */
public class LinkedStack<T> {
    private static class Node<U>{
        U item;
        Node<U> next;
        Node(){
            item = null;
            next = null;
        }
        Node(U item,Node<U> next){
            this.item = item;
            this.next = next;
        }
        boolean end(){
            return item == null && next ==null;
        }
    }

    private Node<T> top = new Node<>();
    //栈进
    public void push(T item){
        top = new Node<>(item,top);
    }
    //栈出
    public T pop(){
        T reuslt = top.item;
       if (!top.end()){
           top = top.next;
       }
       return reuslt;
    }

    public static void main(String[] args){
        LinkedStack<String> lss = new LinkedStack<>();
        for (String s : "ab cd ef gh gk".split(" ")){
            lss.push(s);
        }
        String s;
        while ((s = lss.pop()) != null){
            System.out.println(s);
        }
    }
}
