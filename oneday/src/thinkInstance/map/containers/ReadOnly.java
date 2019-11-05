package thinkInstance.map.containers;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author liutao
 * @Title 容器的不可修改
 * @Description
 * @date 2019-08-15 9:13
 */
public class ReadOnly {

    @Test
    public void unmodifiable(){
        Collection<String> c = new ArrayList<>();
        c.add("aa");
        c.add("bb");
        c.add("cc");
        c.add("dd");
        Collection<String> collection = Collections.unmodifiableCollection(new ArrayList<String>(c));
        List<String> list = Collections.unmodifiableList(new ArrayList<>(c));
        Set<String> set = Collections.unmodifiableSet(new HashSet<>(c));
        Set<String> treeSet = Collections.unmodifiableSet(new TreeSet<>(c));
        Map<String,String> map = Collections.unmodifiableMap(new HashMap<>());
    }

    @Test
    public void synchronizd(){
        Collection<String> collection = Collections.synchronizedCollection(new ArrayList<>());
        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> linkedList = Collections.synchronizedList(new LinkedList<>());
        Set<String> hashSet = Collections.synchronizedSet(new HashSet<>());
        Set<String> treeSet = Collections.synchronizedSet(new TreeSet<>());
        Map<String,Object> map = Collections.synchronizedMap(new HashMap<>());
    }


}
