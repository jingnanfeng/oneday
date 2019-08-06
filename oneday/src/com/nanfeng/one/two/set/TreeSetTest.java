package com.nanfeng.one.two.set;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-17 13:35
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Tom",123));
        parts.add(new Item("ACC",123));
        parts.add(new Item("BSS",123));
        parts.add(new Item("Tom",4));
        System.out.println(parts);
        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription)
        );
        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}
