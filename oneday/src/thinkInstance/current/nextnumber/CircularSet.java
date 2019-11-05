package thinkInstance.current.nextnumber;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-31 21:18
 */
public class CircularSet {

    private int[] array;
    private int len;
    private int index = 0;

    public CircularSet(int size){
        array = new int[size];
        len = size;
        for (int i = 0; i < size; i++) {
            array[i] = -1;
        }
    }

    public synchronized void add(int i){
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val){
        for (int i = 0; i < len; i++) {
            if (array[i] == val){
                return true;
            }
        }
        return false;
    }

}
