package test.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-09 21:21
 */

/**
 * 用继承来设计
 * 在设计程序时，最好的方式首先应该考虑“组合”，组合更加灵活，因为它
 * 可以动态的选择类型，相反，继承在编译时，就需要知道类型
 */

/**
 * 创建一个父类Actor
 */
class Actor{
    public void act(){
        System.out.println("Actor.act");
    }
}

/**
 * 创建子类HappyActor
 */
class HappyActor extends Actor{
    @Override
    public void act() {
        System.out.println("HappyActor.act");
    }
}

/**
 * 创建子类SadActor
 */
class  SadActor extends Actor{
    @Override
    public void act() {
        System.out.println("SadActor.act");
    }
}

/**
 * 创建关联上述的类
 */
class Stage{
    private  Actor actor = new SadActor();

    public void chang(){
        actor = new HappyActor();
    }

    public void performPlay(){
        actor.act();
    }
}

public class Transmogrify {

    public static void main(String[] args) {
        Stage stage = new Stage();
        stage.performPlay();
        stage.chang();
        stage.performPlay();
    }

}
