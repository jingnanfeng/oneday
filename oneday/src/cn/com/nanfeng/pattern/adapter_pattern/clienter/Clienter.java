package cn.com.nanfeng.pattern.adapter_pattern.clienter;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-26 11:46
 */

/**
 * 对象适配器模式
 */

interface Ps2{
    void idps();
}
interface Usb{
    void isUsb();
}

class Usber implements Usb{
    @Override
    public void isUsb() {
        System.out.println("usb");
    }
}

class Adaper implements Ps2{

    private Usb usb;

    public Adaper(Usb usb){
        this.usb = usb;
    }

    @Override
    public void idps() {
        usb.isUsb();
    }
}

public class Clienter {
    public static void main(String[] args) {
        Ps2 ps2 = new Adaper(new Usber());
        ps2.idps();
    }


}
