package com.nanfeng.collection;

import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-25 16:52
 */
public class LinkedHashMap<K,V> extends HashMap<K,V> implements Map<K,V> {



    /*-----------------------构造器--------------------------------*/

    public LinkedHashMap(int initialCapacity,float loadFactory){

    }

    static class Entry<K,V> extends HashMap.Node<K,V>{
        Entry<K,V> before,after;
        Entry(int hash, K key, V value, HashMap.Node<K,V> next){
            super(hash,key,value,next);
        }
    }
}
