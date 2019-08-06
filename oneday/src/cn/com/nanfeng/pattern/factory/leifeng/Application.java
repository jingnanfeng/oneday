package cn.com.nanfeng.pattern.factory.leifeng;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 11:44
 */
class LeiFeng{
    public void Sweep(){
        System.out.println("扫地");
    }
    public void Wash(){
        System.out.println("洗衣");
    }
    public void buyRice(){
        System.out.println("买米");
    }
}

class UnderGraduate extends LeiFeng{
    @Override
    public void Sweep() {
        System.out.println("学雷锋，扫地");
    }

    @Override
    public void Wash() {
        System.out.println("学雷锋,洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println("学雷锋，买米");
    }
}

public class Application {
    public static void main(String[] args) {
        LeiFeng xiaoming = new UnderGraduate();
        xiaoming.Sweep();
        xiaoming.Wash();
        xiaoming.buyRice();
    }
}
