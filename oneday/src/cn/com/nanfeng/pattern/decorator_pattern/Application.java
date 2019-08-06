package cn.com.nanfeng.pattern.decorator_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-11 11:18
 */

/**
 * 装饰者模式：动态地给一个对象添加一些额外的职责，
 * 就增加功能来说，装饰者模式比生成子类更灵活
 */


/**
 * 定义一个对象接口，可以给这些对象动态的添加职责
 */
abstract class Component{
    public abstract void Operator();
}

/**
 * 是一个具体的对象，也可以给这个对象添加一些职责
 */
class ConcreteComponent extends Component{

    @Override
    public void Operator() {
        System.out.println("具体的对象操作");
    }
}

/**
 * 装饰抽象类，继承了Component,重外类来扩展Component类的功能
 */
abstract class Decorator extends Component{

    protected Component component;

    public void SetComponent(Component component){
        this.component = component;
    }

    @Override
    public void Operator(){
        if (component != null){
            component.Operator();
        }
    }
}

/**
 * 具体的装饰对象，起到给Component添加职责发功能
 */
class ConcreteDecoratorA extends Decorator{
    private String addState;

    @Override
    public void Operator() {
        component.Operator();
        addState = "new State";
        System.out.println("具体的装饰类A");
    }
}

/**
 * 具体的装饰对象，起到给Component添加职责发功能
 */
class ConcreteDecoratorB extends Decorator{

    @Override
    public void Operator() {
        component.Operator();
        AddedBehavior();
        System.out.println("具体的装饰类B");
    }

    public void AddedBehavior(){
        System.out.println("这是b的标记");
    }
}


public class Application {

    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB concreteDecoratorB = new ConcreteDecoratorB();

        concreteDecoratorA.SetComponent(concreteComponent);
        concreteDecoratorB.SetComponent(concreteDecoratorA);
        concreteDecoratorB.Operator();
    }
}
