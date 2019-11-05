package test.one.two.TestArrays;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-30 18:04
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()){
                aIter.next();
            }
            aIter.add(bIter.next());
        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
        a.removeAll(b);
        System.out.println(a);
    }

    @Test
    public void test1(){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        ListIterator listIterator = a.listIterator(0);
        while (listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        List<String> b = new LinkedList<>();
        b.add("bb");
        a.addAll(b);
        ListIterator listIterator1 = a.listIterator(0);
        while (listIterator1.hasNext()){
            System.out.println(listIterator1.next());
        }
    }
}
