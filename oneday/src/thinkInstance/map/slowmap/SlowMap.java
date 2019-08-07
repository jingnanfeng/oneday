package thinkInstance.map.slowmap;

import java.util.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-05 8:44
 */
public class SlowMap<K,V> extends AbstractMap<K,V> {

    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public V put(K key, V value){
        V oldValue = get(key);
        if (! keys.contains(key)){
            keys.add(key);
            values.add(value);
        }else {
            values.set(keys.indexOf(key),value);
        }
        return oldValue;
    }

    public V get(Object key){
        if (!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

    public Set<Map.Entry<K,V>> entrySet(){
        Set<Map.Entry<K,V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        }

        return set;
    }

/*    @Override
    public String toString() {
        return "SlowMap{" +
                "keys=" + keys +
                ", values=" + values +
                '}';
    }*/

    public static void main(String[] args) {
        SlowMap<String,String> map = new SlowMap<>();
        map.put("1","a");
        map.put("2","b");
        map.put("3","c");
        map.put("4","d");
        map.put("5","e");
        map.put("6","f");
        System.out.println(map);
        System.out.println("---------------------------------------");
        System.out.println(map.get("1"));
        System.out.println("---------------------------------------");
        System.out.println(map.entrySet());
    }
}
