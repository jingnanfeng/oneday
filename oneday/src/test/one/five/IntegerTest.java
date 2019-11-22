package test.one.five;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-11 10:49
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i1 = new Integer(15);
        Integer i2 = new Integer(15);
        System.out.println(i1 == i2);

        Integer i3 = 156;
        Integer i4 = 156;

        Integer i5 = Integer.valueOf(156);

        System.out.println(i3 == i4);
        System.out.println(i3 == i5);
    }

}
