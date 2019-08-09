package thinkInstance.map.containers;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-09 8:38
 */
public abstract class Test<C> {
    String name;
    public Test(String name){
        this.name = name;
    }
    abstract int test(C container,TestParam tp);
}
