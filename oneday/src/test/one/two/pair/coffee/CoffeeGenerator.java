package test.one.two.pair.coffee;

import java.util.Iterator;
import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 9:42
 */
public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee> {

    private Class[] types = {
            Cappuccing.class,Latte.class,Mocha.class
    };

    private static Random random = new Random(47);

    public CoffeeGenerator(){}

    private int size = 0;
    public CoffeeGenerator(int size){
        this.size = size;
    }

    @Override
    public Coffee next(){
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    class CoffeeIteratro implements Iterator<Coffee>{

        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIteratro();
    }

    public static void main(String[] args) {
        CoffeeGenerator gen = new CoffeeGenerator();
        for (int i = 0;i<5;i++){
            System.out.println(gen.next());
        }

        for (Coffee coffee : new CoffeeGenerator(5)){
            System.out.println(coffee);
        }
    }
}
