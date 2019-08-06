package cn.com.nanfeng.pattern.decorator_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-14 18:03
 */

/**
 * 父类，鸟类
 */
abstract class Bird{

    public abstract int fly();
}

/**
 * 具体组件
 */
class Sparrow extends Bird{

    private static final int DISTANCE = 100;

    @Override
    public int fly() {
        return DISTANCE;
    }
}

/**
 * 装饰类
 */

abstract class Decorator1 extends Bird{
    protected Bird bird;

    public Decorator1(){

    }

    public Decorator1(Bird bird){
        this.bird = bird;
    }
}

/**
 * 具体装饰类
 */

class SparrowDecoator extends Decorator1{

    public static final int DISTANCE = 50;

    public SparrowDecoator(Bird bird){
        super(bird);
    }

    @Override
    public int fly() {
        int distance = 0;
        distance = bird.fly() +DISTANCE;
        return distance;
    }
}

public class BirdApplication {

    public void needBrid(Bird bird){
        int flyDistance = bird.fly();
        System.out.println("这只鸟能飞"+flyDistance+"米");
    }

    public static void main(String[] args) {
        BirdApplication birdApplication = new BirdApplication();
        Bird bird = new Sparrow();

        Bird sbird = new SparrowDecoator(bird);
        Bird sbirds = new SparrowDecoator(sbird);

        birdApplication.needBrid(sbird);
        birdApplication.needBrid(sbirds);

    }
}
