package pattern.decorator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-19 15:46
 */

/**
 * ConcreteComponent
 */
class Person{

    private String name;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    public void show(){
        System.out.println("装饰为0"+name);
    }
}

/**
 * 装饰类（Decorator）
 */
class Finery extends Person{

    private Person compontent;

    //打扮
    public void Decorate(Person compontent){
        this.compontent = compontent;
    }
    @Override
    public void show(){
        if (compontent != null){
            compontent.show();
        }
    }
}
class Tshirts extends Finery{

    @Override
    public void show(){
        System.out.println("大T恤");
        super.show();
    }
}
class BigTrouser extends Finery{

    @Override
    public void show(){
        System.out.println("跨库");
        super.show();
    }
}

public class CostumeApplication {

    public static void main(String[] args) {
        Person person = new Person("小明");
        System.out.println("第一种装扮");

        Tshirts tshirts = new Tshirts();
        BigTrouser bigTrouser = new BigTrouser();

        tshirts.Decorate(person);
        bigTrouser.Decorate(tshirts);
        bigTrouser.show();

    }
}
