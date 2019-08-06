package com.nanfeng.thinkInstance.map.slowmap;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-06 8:39
 */
public class SimpleHashMap<K,V> extends AbstractMap<K,V> {

    static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value){
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }
        LinkedList<MapEntry<K,V>> bucket = buckets[index];
        MapEntry<K,V> pair = new MapEntry<>(key,value);
        boolean found = false;
        ListIterator<MapEntry<K,V>> it = bucket.listIterator();
        while (it.hasNext()){
            MapEntry<K,V> iPair = it.next();
            if (iPair.getKey().equals(key)){
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found){
            buckets[index].add(pair);
        }
        return oldValue;
    }

    public V get(Object key){
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null){
            return null;
        }
        for (MapEntry<K,V> iPair : buckets[index]){
            if (iPair.getKey().equals(key)){
                return iPair.getValue();
            }
        }
        return null;
    }
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K,V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null){
                continue;
            }
            for (MapEntry<K, V> entry : bucket) {
                set.add(entry);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        SimpleHashMap<String,String> map = new SimpleHashMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","e");
        map.put("5","f");
        map.put("6","a");
        map.put("7","a");
        System.out.println(map);
        System.out.println(map.get("1"));
        System.out.println(map.entrySet());
    }

}
