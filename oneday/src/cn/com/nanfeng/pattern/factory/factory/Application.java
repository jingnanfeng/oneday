package cn.com.nanfeng.pattern.factory.factory;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-16 10:43
 */

/**
 * 建立一个抽象父类
 */

/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实例化哪一个类
 * 工厂方法是一个类的实例化延迟到其子类
 */

abstract class Operation{
    private Integer numberA;
    private Integer numberB;

    public Integer getNumberA() {
        return numberA;
    }

    public void setNumberA(Integer numberA) {
        this.numberA = numberA;
    }

    public Integer getNumberB() {
        return numberB;
    }

    public void setNumberB(Integer numberB) {
        this.numberB = numberB;
    }

    public abstract Integer getResult();
}

/**
 * 具体的加法类
 */
class AddOpration extends Operation{
    @Override
    public Integer getResult() {
        int result = getNumberA() + getNumberB();
        return result;
    }
}
/**
 * 具体的乘法类
 */
class MulOpration extends Operation{

    @Override
    public Integer getResult() {
        int result = getNumberA() * getNumberB();
        return result;
    }
}

/**
 * 抽象工厂
 */
interface Factory{

    Operation createOperation();

}

/**
 * 具体的加法工厂
 */
class AddFactory implements Factory{
    @Override
    public Operation createOperation() {
        return new AddOpration();
    }
}

/**
 * 具体的乘法工厂
 */
class MulFactory implements Factory{
    @Override
    public Operation createOperation() {
        return new MulOpration();
    }
}

public class Application {

    public static void main(String[] args) {
        Factory addfFactory = new AddFactory();
        Operation addoption = addfFactory.createOperation();
        addoption.setNumberA(5);
        addoption.setNumberB(6);
        int result = addoption.getResult();
        System.out.println(result);
    }

}
