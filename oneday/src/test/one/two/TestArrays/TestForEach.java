package test.one.two.TestArrays;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-30 9:25
 */
public class TestForEach {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int n = 0;
        while (n < 10){
            list.add(n+"");
            n++;
        }
        Iterator<String> iterator = list.iterator();
        iterator.forEachRemaining(t -> System.out.print(t+" "));

        contains(list,"1");
    }

    @Test
    void test(){
        List<String> list = new ArrayList<>();
        int n = 0;
        while (n < 10){
            list.add(n+"");
            n++;
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println( iterator.next());
            iterator.remove();
        }
        System.out.println("-----------------------------------------");
        System.out.println(list.size());

    }

    public static <E>boolean contains(Collection<E> c, Object obj){
        for (E e : c) {
            if (e.equals(obj)){
                return true;
            }
        }
        return false;
    }
}
