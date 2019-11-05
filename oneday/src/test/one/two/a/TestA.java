package test.one.two.a;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-26 11:56
 */
public interface TestA {

    default void testa(){
        System.out.println("aa");
    }
    void testb();

}

interface TestD{
    default void testa(){
        System.out.println("aa");
    }
}
class TestB implements TestA,TestD{

    @Override
    public void testa(){

    }

    @Override
    public void testb() {
        System.out.println("bb");
    }
}
class TestC{
    public static void main(String[] args) {
        TestA testA = new TestB();
        testA.testa();
        testA.testb();
        }
}
