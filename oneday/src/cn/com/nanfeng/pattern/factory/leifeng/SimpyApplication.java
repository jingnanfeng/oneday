package cn.com.nanfeng.pattern.factory.leifeng;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 13:36
 */

/**
 * 使用简单工厂完成学雷锋
 */

/**
 * 雷锋类
 */
interface SimpyLeifeng{

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

class Student implements SimpyLeifeng{
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

class Volunteer implements SimpyLeifeng{
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

class Factory{

    public SimpyLeifeng create(String type){
        SimpyLeifeng simpyLeifeng = null;
        switch (type){
            case "学生":
                simpyLeifeng = new Student();
                break;
            case "志愿者":
                simpyLeifeng = new Volunteer();
                break;
                default:
                    throw new RuntimeException("暂无此业务");
        }
        return simpyLeifeng;
    }

}

public class SimpyApplication {

    public static void main(String[] args) {
        Factory factory = new Factory();
        SimpyLeifeng simpyLeifeng = factory.create("学生");
        simpyLeifeng.buyRish();
        simpyLeifeng.Sweep();
        simpyLeifeng.Wash();
    }


}
