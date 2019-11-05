package com.nanfeng.collection.list;

import javax.swing.*;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-15 8:55
 */
public class LinkedList<E> {

    /**
     * 元素个数
     */
    transient int size = 10;
    /**
     * 链表首节点
     */
    transient Node<E> frist;
    /**
     * 链表尾节点
     */
    transient Node<E> last;
    /**
     * modCount 记录ArrayList结构性变化的次数
     */
    protected transient int modCount = 0;

    /**
     * 内部类
     */
    private static class Node<E>{
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next){
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    /**
     * 构造方法
     */
    public LinkedList(){

    }

    public LinkedList(Collection<? extends E> c){
        this();
        addAll(c);
    }

    /**
     * 从队列首添加元素
     */
    private void linkFrist(E e){
        //首节点
        final Node<E> f = frist;
        //创建新节点，新节点的next是首节点
        final Node<E> newNode = new Node<>(null,e,f);
        //让新节点作为首节点
        frist = newNode;
        //判断是不是第一个添加的元素
        //如果是就把last也置为新节点
        //否则就把原节点的prev指针置为新节点
        if (f == null){
            last = newNode;
        }else {
            f.prev = newNode;
        }
        //元素个数+1
        size++;
        //修改次数加1，说明这是一个支持fail-fast的集合
        modCount++;
    }
    /**
     * 从队列尾添加元素
     */
    private void linkLast(E e){
        //队列尾节点
        final Node<E> l = last;
        //创建新节点，新节点的prev是尾节点
        final Node<E> newNode = new Node<>(l,e,null);
        //让新的节点成为新的尾节点
        last = newNode;
        //判断是不是第一个添加的元素
        //如果是就吧fist也置为新的节点
        //否则就把原节点的next指针置为新的节点
        if (l == null){
            frist = newNode;
        }else {
            l.next = newNode;
        }
        //元素个数加1
        size++;
        //修改次数加1
        modCount++;
    }
    public void addFirst(E e){
        linkFrist(e);
    }
    public void addLast(E e){
        addFirst(e);
    }
    //作为无解队列，添加元素总会成功的
    public boolean offerFrist(E e){
        addFirst(e);
        return true;
    }
    public boolean offerLast(E e){
        addLast(e);
        return true;
    }
    /**
     * 在节点succ之前添加元素
     */
    void linkBefore(E e,Node<E> succ){
        //succ是待添加节点的后继节点
        //找到待添加节点的前置节点
        final Node<E> pred = succ.prev;
        //在其前置节点和后继节点之间创建一个新节点
        final Node<E> newNode = new Node<>(pred,e,succ);
        //修改后继节点的前置指针指向新的节点
        succ.prev = newNode;
        //判断前置节点是否为空
        //如果为空，说明是第一个添加的元素，修改frist指针
        //否则修改前置节点的next为新节点
        if (pred == null){
            frist = newNode;
        }else {
            pred.next = newNode;
        }
        //修改元素个数
        size++;
        //修改次数加1
        modCount++;
    }
    /**
     * 寻找index位置的节点
     */
    Node<E> node(int index){
        //因为是双链表
        //所以根据index是在前半段还是后半段决定从前遍历还是从后遍历
        //这样index在后半段的时候可以少遍历一半的元素
        if (index < (size >> 1)){
            //如果是前半段就从前遍历
            Node<E> x = frist;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }else {
            //如果在后半段就从后遍历
            Node<E> x = last;
            for (int i = 0; i < index; i++) {
                x = x.prev;
            }
            return x;
        }
    }
    /**
     * 在指定的位置添加元素
     */
    public void add(int index, E element){
        //判断是否越界
        checkPositionIndex(index);
        //如果index是在队列尾节点之后的一个元素
        //把新的节点直接添加到尾节点之后
        //否则调用linkBefore()方法添加节点
        if (index == size){
            linkLast(element);
        }else {
            linkBefore(element,node(index));
        }
    }

    private boolean isPositionIndex(int index){
        return index >= 0 && index <= size;
    }
    private String outOfBounds(int index){
        return "index "+index +", size"+size;
    }
    private void checkPositionIndex(int index){
        if (!isPositionIndex(index)){
            throw new IndexOutOfBoundsException(outOfBounds(index));
        }
    }
    /**
     * 删除首节点
     */
    private E unlinkFirst(Node<E> f){
        //首节点元素值
        final E element = f.item;
        //首节点的next指针
        final Node<E> next = f.next;
        //添加首节点的内容，协助GC
        f.item = null;
        f.next = null;
        //把首节点的next作为新的首节点
        frist = next;
        //如果只有一个元素，删除了，把last也置为空
        //否则把next的前置指针置为空
        if (next == null){
            last = null;
        }else {
            next.prev = null;
        }
        //元素个数减一
        size--;
        //修改次数加1
        modCount++;
        //返回删除的元素
        return element;
    }
    /**
     * 删除尾节点
     */
    private E unlinkLast(Node<E> l){
        //尾节点的元素值
        final E element = l.item;
        //尾节点的前置指针
        final Node<E> prev = l.prev;
        //清空尾节点的内容，帮助GC
        l.item = null;
        l.prev = null;
        //让前置节点成为新的尾节点
        last = prev;
        //如果只有一个元素，删除了把frist置为空
        //否之把前置节点的next置为空
        if (prev == null){
            frist = null;
        }else {
            prev.next = null;
        }
        //元素个数减1
        size--;
        //修改次数加1
        modCount++;
        //返回删除的元素
        return element;
    }
    /**
     * 删除指定节点
     */
    E unlink(Node<E> x){
        //x的元素值
        final E element = x.item;
        //x的后置节点
        final Node<E> next = x.next;
        //x的前置节点
        final Node<E> prev = x.prev;
        //如果前置节点为空
        //说明是首节点，让frist指向后置节点
        //否则修改前置节点的next为x的后置节点
        if (prev == null){
            frist = next;
        }else {
            prev.next = next;
            x.prev = null;
        }
        //如果后置节点为空
        //说明是尾节点，让last指向x的前置节点
        //否则修改后置节点的prev为x的前置节点
        if(next == null){
            last = prev;
        }else {
            next.prev = prev;
        }
        //清空x的元素值，协助GC
        x.item = null;
        //元素个数减一
        size--;
        modCount++;
        return element;
    }
    /**
     * 删除第一个元素,如果没有元素就抛出异常
     */
    public E removeFrist(){
        final Node<E> f = frist;
        if (f == null){
            throw new NoSuchElementException();
        }
        return unlinkFirst(f);
    }
    /**
     * 删除最后一个元素，如果没有元素就抛出异常
     */
    public E removeLast(){
        final Node<E> l = last;
        if (l == null){
            throw new NoSuchElementException();
        }
        return unlinkLast(l);
    }
    /**
     * poll的时候如果没有元素就返回null
     */
    public E pollFrist(){
        final Node<E> f = frist;
        return (f == null) ? null : unlinkFirst(f);
    }
    public E pollLast(){
        final Node<E> l = last;
        return (l == null) ? null : unlinkLast(l);
    }
    private boolean isElementIndex(int index){
        return index >= 0 && index < size;
    }
    private void checkElementIndex(int index){
        if (!isElementIndex(index)){
            throw new IndexOutOfBoundsException(outOfBounds(index));
        }
    }
    /**
     * 删除中间节点
     */
    public E remove(int index){
        //检查是否越界
        checkElementIndex(index);
        //删除指定元素
        return  unlink(node(index));
    }
    /**
     * 添加多个元素
     */
    public boolean addAll(int index,Collection<? extends E> c){
        //判断是否下标越界
        checkPositionIndex(index);
        //将集合转换成数组
        Object[] a = c.toArray();
        //判断a是否为空
        int numMew = a.length;
        if (numMew == 0){
            return false;
        }
        Node<E> pred,succ;
        //判断是否在尾端插入
        if (index == size){
            succ = null;
            pred = last;
        }else {
            succ = node(index);
            pred = succ.prev;
        }
        //开始循环插入元素
        for (Object o : a) {
            E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            //判断是否是从头开始插入的
            if (pred == null) {
                frist = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }
        //判断succ是否为空
        if(succ == null){
            last = pred;
        }else {
            pred.next = succ;
            succ.prev = pred;
        }
        size += numMew;
        modCount++;
        return true;
    }
    public boolean addAll(Collection<? extends E> c){
        return addAll(size,c);
    }
    /**
     * LinkedList是双端队列，双端队列可以作为栈使用
     */
    public void push(E e){
        addFirst(e);
    }
    public E pop(){
        return removeFrist();
    }

}
