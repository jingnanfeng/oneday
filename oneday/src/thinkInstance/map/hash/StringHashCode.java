package thinkInstance.map.hash;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-07 9:10
 */
public class StringHashCode {
    public static void main(String[] args) {
        String[] hellos = "hello hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }

}
