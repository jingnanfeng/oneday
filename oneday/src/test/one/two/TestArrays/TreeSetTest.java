package test.one.two.TestArrays;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-05 10:08
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);
        NavigableSet<Item> set = new TreeSet<>();
        Comparator.comparing(Item::getDescription);
        set.addAll(parts);
        System.out.println(set);
    }


}
