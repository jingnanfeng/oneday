package cn.com.nanfeng.pattern.decorator_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-11 13:43
 */

/**
 * 抽象的人类
 */
abstract class Person{

    private String name;

    public abstract void Show();

}

/**
 * 超人
 */
class SuperMan extends Person{

    private String name;

    public SuperMan(){}

    public SuperMan(String name){
        this.name = name;
    }

    @Override
    public void Show() {
        System.out.println("装扮的"+name);
    }
}

/**
 * 抽象的服装类
 */
class Finery extends Person{

    protected Person person;

    //打扮
    public void Decorate(Person person){
        this.person = person;
    }

    @Override
    public void Show() {
        if (person != null){
            person.Show();
        }

    }
}

/**
 * 具体的服装装扮
 */
class TShirts extends Finery{

    @Override
    public void Show() {
        System.out.print("小体恤 ");
        super.Show();
    }
}
class BigTrouser extends Finery{

    @Override
    public void Show() {
        System.out.print("垮裤 ");
        super.Show();
    }
}

/**
 * 客户端
 * @author liutao
 */
public class ClothApplication {
    public static void main(String[] args) {
        Person person = new SuperMan("超人");
        TShirts tShirts = new TShirts();
        BigTrouser bigTrouser = new BigTrouser();

        tShirts.Decorate(person);
        bigTrouser.Decorate(tShirts);

        bigTrouser.Show();
    }


}
