package thinkInstance.map.slowmap;

import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-05 8:55
 */
public class MapEntry<K,V> implements Map.Entry<K,V> {

    private K key;
    private V value;

    public MapEntry(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public int hashCode(){
        return (key == null ? 0 : key.hashCode()) ^
                (value == null ? 0 : value.hashCode());
    }

    public boolean equals(Object o){

        if (!(o instanceof MapEntry)){
            return false;
        }
        MapEntry me = (MapEntry)o;
        return (key == null ? me.key == null : key.equals(me.getKey())) &&
                (value == null ? me.value == null : value.equals(me.getValue()));
    }
    public String toString(){
        return key + " = " +value;
    }

}
