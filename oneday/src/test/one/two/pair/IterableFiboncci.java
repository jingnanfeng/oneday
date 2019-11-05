package test.one.two.pair;

import java.util.Iterator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 10:12
 */
public class IterableFiboncci extends Fibonacci implements Iterable<Integer> {

    private int n;

    public IterableFiboncci(int count){
        n = count;
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>(){
            public boolean hasNext(){
                return n > 0;
            }
            public Integer next(){
                n--;
                return IterableFiboncci.this.next();
            }
            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFiboncci(18)){
            System.out.println(i + " ");
        }
    }
}
