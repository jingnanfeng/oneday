package cn.com.nanfeng.pattern.factory.leifeng;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 14:50
 */

/**
 * 内部类+工厂方法，让代码变得更优雅简洁
 */

/**
 * 抽象类
 */
interface InnerLeiFeng{
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

/**
 * 抽象工厂
 */
interface InnerFactory{

    InnerLeiFeng getResult();
}

/**
 * 具体学生类
 */

class InnerStudent implements InnerLeiFeng{
    @Override
    public void Sweep() {
        System.out.println("学生扫地");
    }

    @Override
    public void Wash() {
        System.out.println("学生洗衣");
    }

    @Override
    public void buyRish() {
        System.out.println("学生买米");
    }

    public static InnerFactory innerFactory = new InnerFactory() {
        @Override
        public InnerLeiFeng getResult() {
            return new InnerStudent();
        }
    };
}

/**
 * 具体的志愿者类
 */
class InnerVoiunteer implements InnerLeiFeng{
    @Override
    public void Sweep() {
        System.out.println("志愿者扫地");
    }

    @Override
    public void Wash() {
        System.out.println("志愿者洗衣");
    }

    @Override
    public void buyRish() {
        System.out.println("志愿者买米");
    }

    public static InnerFactory innerFactory = new InnerFactory() {
        @Override
        public InnerLeiFeng getResult() {
            return new InnerVoiunteer();
        }
    };
}
public class InnerFactoryApplication {

    public void create(InnerFactory innerFactory){
        InnerLeiFeng innerLeiFeng = innerFactory.getResult();
        innerLeiFeng.buyRish();
        innerLeiFeng.Sweep();
        innerLeiFeng.Wash();
    }

    public static void main(String[] args) {
        InnerFactoryApplication inner = new InnerFactoryApplication();
        inner.create(InnerVoiunteer.innerFactory);
    }
}
