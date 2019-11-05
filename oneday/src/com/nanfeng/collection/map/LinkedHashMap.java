package com.nanfeng.collection.map;

import com.nanfeng.collection.map.HashMap;

import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-25 16:52
 */
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {

    /**
     * 双向链表的头节点
     */
    transient LinkedHashMap.Entry<K,V> hrea;
    /**
     * 双向链表的尾节点
     */
    transient LinkedHashMap.Entry<K,V> tail;

    /**
     * 是否按访问顺序排列
     */
    final boolean accessOrder;



    /*-----------------------构造器--------------------------------*/

    public LinkedHashMap(int initialCapacity,float loadFactory){
        super(initialCapacity,loadFactory);
        accessOrder = false;
    }

    public LinkedHashMap(){
        super();
        accessOrder = false;
    }

    public LinkedHashMap(Map<? extends K,? extends V> m){
        super();
        accessOrder = false;
        putMapEnties(m,false);
    }

    public LinkedHashMap(int initialCapacity,float loadFactory,
                         boolean accessOrder){
        super(initialCapacity,loadFactory);
        this.accessOrder = accessOrder;
    }

    private void putMapEnties(Map<? extends K,? extends V> m, boolean b) {
    }

    static class Entry<K,V> extends HashMap.Node<K,V>{
        Entry<K,V> before,after;
        Entry(int hash, K key, V value, HashMap.Node<K,V> next){
            super(hash,key,value,next);
        }
    }
}
