package test.one.two;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-04 15:14
 */

class Product{
    Product(String s){
        System.out.println("这是一个商品");
    }


}

public class Person {

    private Product product = new Product("这是一个商品");

    static {
        System.out.println("初始化一个人");
    }

    public static void eat(){
        System.out.println("一个人在吃饭");
    }

    public void run(){
        System.out.println("一个人在跑步");
    }

}
class Student extends Person{


    static {
        System.out.println("初始化学生");
    }

    public static void eat(){
        System.out.println("学生在吃饭");
    }

    @Override
    public void run(){
        System.out.println("学生在跑步");
    }
}
