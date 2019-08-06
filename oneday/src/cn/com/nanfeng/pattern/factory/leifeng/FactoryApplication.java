package cn.com.nanfeng.pattern.factory.leifeng;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 14:04
 */

/**
 * 用工厂类完成学雷锋事件
 */
interface Leifeng{
    /**
     * 扫地
     */
    void Sweep();

    /**
     * 洗衣
     */
    void Wash();

    /**
     * 买米
     */
    void buyRish();
}
class Student1 implements Leifeng{
    @Override
    public void Sweep() {
        System.out.println("学生学雷锋扫地");
    }

    @Override
    public void Wash() {
        System.out.println("学生学雷锋洗衣");
    }

    @Override
    public void buyRish() {
        System.out.println("学生学雷锋买米");
    }
}

class Volunteer1 implements Leifeng{
    @Override
    public void Sweep() {
        System.out.println("志愿者学雷锋扫地");
    }

    @Override
    public void Wash() {
        System.out.println("志愿者学雷锋洗衣");
    }

    @Override
    public void buyRish() {
        System.out.println("志愿者学雷锋买米");
    }
}

/**
 * 创建工厂父类
 */
interface Factory1{

    Leifeng createFactory();
}

/**
 * 学生的具体工厂
 */
class StudentFactory implements Factory1{
    @Override
    public Leifeng createFactory() {
        return new Student1();
    }
}

/**
 * 志愿者的具体工厂
 */
class VolunteerFactory implements Factory1{
    @Override
    public Leifeng createFactory() {
        return new Volunteer1();
    }
}

public class FactoryApplication {
    public static void main(String[] args) {
        Factory1 factory1 = new StudentFactory();
        Leifeng factory = factory1.createFactory();
        factory.buyRish();
        factory.Sweep();
        factory.Wash();
    }
}
