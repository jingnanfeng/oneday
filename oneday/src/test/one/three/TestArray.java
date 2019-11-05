package test.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-03-23 11:17
 */
public class TestArray {
    TestArray(String string){
        System.out.println("String"+string);
    }

    static void testA(int a ,Object...objs){
        for (Object o:objs) {
            System.out.println("o"+o);
        }
    }

    @Override
    public String toString() {
        return "aa";
    }

    static void t( float f ,Character...chars){

    }
    static void t( int a,Character...chars){

    }

    public static void main(String[] args) {
        TestArray testArray = new TestArray("aaa");
        TestArray[] testArrays = new TestArray[]{testArray};
        testA(1,new Object[]{"aa",22,new TestArray("aa").toString()});



    }
}
