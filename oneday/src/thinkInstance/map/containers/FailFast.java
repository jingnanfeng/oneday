package thinkInstance.map.containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-15 8:49
 */
public class FailFast {

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        Iterator<String> it = c.iterator();
        c.add("aa");
        try {
            String s = it.next();
        }catch (ConcurrentModificationException e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
