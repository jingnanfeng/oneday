package test.one.two.pair;

import test.one.two.pair.coffee.Generator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 10:03
 */
public class Fibonacci implements Generator<Integer> {

    private int count = 0;

    @Override
    public Integer next() {
        return fib(count++);
    }
    public int fib(int n){
        if (n < 2){
            return n;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 18;i++){
            System.out.println(fibonacci.next()+" ");
        }
    }

}
