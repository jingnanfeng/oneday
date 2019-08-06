package com.nanfeng.one.two.TestArrays;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-18 15:04
 */
public class TestOrder {

    public static <T extends Comparable> T order(Collection<T> coll) {
        if (coll.isEmpty()){
            throw new RuntimeException();
        }
        Iterator<T> iter = coll.iterator();
         T largest = iter.next();
        while (iter.hasNext()){
            T next = iter.next();
            if (largest.compareTo(next) < 0){
                largest = next;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        List<Manager> stringList = new ArrayList<>();

        stringList.add(new Manager(2,"bb"));
        stringList.add(new Manager(3,"cc"));
        stringList.add(new Manager(4,"dd"));
        stringList.add(new Manager(5,"ee"));
        stringList.add(new Manager(1,"aa"));
        Manager order = order(stringList);
        System.out.println(order);

        stringList.sort(Comparator.comparingInt(Manager::getId));
        stringList.sort(Comparator.comparingInt(Manager::getId).reversed());
    }



}

class Manager implements Comparable<Manager>{
    private Integer id;
    private  String name;

    public Manager(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Manager() {
    }

    @Override
    public int compareTo(Manager o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}