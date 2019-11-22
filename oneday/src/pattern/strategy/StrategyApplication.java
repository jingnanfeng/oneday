package pattern.strategy;

/**
 * @author liutao
 * @Title 策略模式
 * @Description 它定义了算法家族，分别封装起来，让他们之间可以互相替换，
 * 此模式让算法的变化，不会影响的使用算法的用户
 * @date 2019-11-19 10:49
 */

/**
 * 抽象算法类
 */
abstract class Strategy{
    /**
     * 算法方法
     */
    public abstract void algorithmInterface();
}

/**
 * 具体的算法或行为
 */
class StrategyA extends Strategy{

    /**
     * 实现算法A
     */
    @Override
    public void algorithmInterface() {
        System.out.println("实现算法A");
    }
}

/**
 * 具体的算法或者行为B
 */
class StrategyB extends Strategy{
    /**
     * 实现算法B
     */
    @Override
    public void algorithmInterface() {
        System.out.println("实现算法B");
    }
}

/**
 * 具体算法C
 */
class StrategyC extends Strategy{
    /**
     * 实现算法C
     */
    @Override
    public void algorithmInterface() {
        System.out.println("实现算法C");
    }
}

/**
 * 上下文
 */
class Context{

    private Strategy strategy;

    //在初始化时，传入具体的策略模式
    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    /**
     * 上下文接口
     */
    public void ContextInterface(){
        strategy.algorithmInterface();
    }
}



public class StrategyApplication {

    public static void main(String[] args) {
        Context context = null;
        //使用策略A
        context = new Context(new StrategyA());
        context.ContextInterface();
        //使用策略B
        context = new Context(new StrategyB());
        context.ContextInterface();
        //使用策略C
        context = new Context(new StrategyC());
        context.ContextInterface();
    }


}
