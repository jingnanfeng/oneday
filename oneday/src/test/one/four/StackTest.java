package test.one.four;

import java.util.LinkedList;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-20 9:36
 */
class Stack<T>{
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){storage.addFirst(v);}
    public T peek(){return storage.getFirst();}
    public T pop(){return storage.remove();}
    public boolean empty(){return storage.isEmpty();}
    @Override
    public String toString(){return storage.toString();}
}

public class StackTest {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String[] strs = "aa bb cc dd".split(" ");
        for(String s : strs){
            stack.push(s);
        }
        System.out.println(stack.toString());

        String peekFrist = stack.peek();
        System.out.println(peekFrist);

        String popFrist = stack.pop();
        System.out.println(popFrist);

        String peekFrist1 = stack.peek();
        System.out.println(stack.toString());
    }

}
