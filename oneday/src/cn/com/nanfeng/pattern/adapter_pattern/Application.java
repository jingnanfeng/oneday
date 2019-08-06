package cn.com.nanfeng.pattern.adapter_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 10:45
 */

/**
 * 适配器模式：是作为两个不兼容的接口之间的桥梁，属于结构型模式，
 * 它结合两个独立的接口
 * 意图：将一个类的接口转换成客户希望的另一个接口，
 * 适配器模式使得原本由接口不兼容而不能一起工作的那些类可以一起工作
 */
interface Ps2{
    void isPs2();
}

interface Usb{
    void isUsb();
}

class Usber implements Usb{

    @Override
    public void isUsb() {
        System.out.println("USB");
    }
}

class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }
}

public class Application {

    public static void main(String[] args) {
        Ps2 p =new Adapter();
        p.isPs2();
    }

}
