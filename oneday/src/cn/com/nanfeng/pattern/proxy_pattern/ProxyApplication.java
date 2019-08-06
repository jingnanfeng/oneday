package cn.com.nanfeng.pattern.proxy_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-15 14:40
 */

/**
 * 代理模式：为其他对象提供一种代理以控制对这个对象的访问
 */

/**
 * 追求者和代理者实现共同的接口
 */
interface GiveGift{

    void giveDolls();
    void giveFlowers();
    void giveChocolate();

}

/**
 * 追求者
 */
class Pursuit1 implements GiveGift{

    protected Girl girl;

    public Pursuit1(Girl girl){
        this.girl = girl;
    }

    @Override
    public void giveDolls() {
        System.out.println(girl.getName()+",送给你洋娃娃");
    }

    @Override
    public void giveFlowers() {
        System.out.println(girl.getName()+",送给你鲜花");
    }

    @Override
    public void giveChocolate() {
        System.out.println(girl.getName()+",送给你巧克力");
    }
}

/**
 * 代理类
 */
class Proxy implements GiveGift{

    private Pursuit1 pursuit1;

    public Proxy(Girl girl){
        this.pursuit1 = new Pursuit1(girl);
    }

    @Override
    public void giveDolls() {
        pursuit1.giveDolls();
    }

    @Override
    public void giveFlowers() {
        pursuit1.giveFlowers();
    }

    @Override
    public void giveChocolate() {
        pursuit1.giveChocolate();
    }
}

class Girl{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ProxyApplication {
    public static void main(String[] args) {
        Girl girl = new Girl();
        girl.setName("娇娇");

        GiveGift giveGift = new Proxy(girl);

        giveGift.giveChocolate();
        giveGift.giveDolls();
        giveGift.giveFlowers();
    }

}
