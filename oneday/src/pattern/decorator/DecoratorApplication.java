package pattern.decorator;

/**
 * @author liutao
 * @Title  装饰模式
 * @Description 动态地给一个对象添加一些额外的职责，就增减功能来说，
 * 装饰模式比生成子类更加的灵活
 * @date 2019-11-19 13:57
 */

/**
 * 是定义一个对象的接口，可以给这些对象动态的添加职责
 */
abstract class Component{
    public abstract void operation();
}

/**
 * 定义了一个具体的对象，也可以给这个对象添加一些职责
 */
class ConcreteComponent extends Component{
    @Override
    public void operation() {
        System.out.println("具体的对象操作");
    }
}

/**
 * 装饰抽象类，继承了Component
 */
abstract class Decorator extends Component{
    protected Component component;

    public void setComponent(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        if (component != null){
            component.operation();
        }
    }
}

/**
 * 具体的装饰类
 */
class ConcreteDecoratorA extends Decorator{
    private String addedState;

    @Override
    public void operation(){
       super.operation();
        addedState = "New State";
        System.out.println("具体的装饰对象A的操作");
    }
}

/**
 * 具体的装饰类
 */
class ConcreteDecoratorB extends Decorator{

    private void addedBehavior(){

    }
    @Override
    public void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体的装饰对象B的操作");
    }
}

public class DecoratorApplication {
    public static void main(String[] args) {
        ConcreteComponent component = new ConcreteComponent();

        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();

        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();

        decoratorA.setComponent(component);
        decoratorB.setComponent(decoratorA);
        decoratorB.operation();

    }
}
