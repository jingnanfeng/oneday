package cn.com.nanfeng.pattern.protptype_pattren;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-20 14:05
 */

/**
 * 原型模式，用原型实例指定创建对象的种类，
 * 并且通过拷贝这些原型创建新的对象
 *
 * 原型模式其实就是从一个对象再创建另外一个可制定的对象，并且不需要任何创建的细节
 */
abstract class Prototype{
    private String id;

    public Prototype(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract Prototype Clone();
}

class ConcretePrototype extends Prototype {

    public ConcretePrototype(String id) {
        super(id);
    }

    @Override
    public Prototype Clone() {
        return null;
    }


}
public class PrototypeApplication {


}
