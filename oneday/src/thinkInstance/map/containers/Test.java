package thinkInstance.map.containers;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-08 9:00
 */
public abstract class Test<C> {

    String name;
    public Test(String name){
        this.name = name;
    }
    abstract int test(C container,TestParam tp);

}
