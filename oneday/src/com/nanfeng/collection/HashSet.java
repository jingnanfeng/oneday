package com.nanfeng.collection;

import java.io.Serializable;
import java.util.*;


import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-25 17:30
 */
public class HashSet<E> extends AbstractSet<E> implements
        Set<E>,Cloneable, Serializable {
    private static final long serialVersionUID = 6515490688894574833L;

    private transient HashMap<E,Object> map;
    /**
     * 虚拟对象，用来做value放到map中
     */
    private static final Object PRESENT = new Object();

    /*--------------------------------构造方法--------------------------*/
    public HashSet(){
        map = new HashMap<>();
    }
    public HashSet(Collection<? extends E> c){
        map = new HashMap<>(Math.max((int)(c.size()/.75f) + 1 ,16));
    }
    public HashSet(int initialCapacity,float loadFactory){
        map = new HashMap<>(initialCapacity,loadFactory);
    }
    public HashSet(int initialCapacity){
        map = new HashMap<>(initialCapacity);
    }
    HashSet(int initialCapacity, float loadFactory, boolean dummy){
        map = new LinkedHashMap<>(initialCapacity,loadFactory);
    }


    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    @Override
    public Stream<E> stream() {
        return null;
    }

    @Override
    public Stream<E> parallelStream() {
        return null;
    }
}
