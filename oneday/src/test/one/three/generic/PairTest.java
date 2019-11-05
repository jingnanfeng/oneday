package test.one.three.generic;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-06-10 15:23
 */
public class PairTest {
    public static void main(String[] args) {
        String[] words = {"Liu","Wang","sun","Z"};
        Pair<String> mm = ArrayAlg.minMax(words);
        System.out.println("min = "+mm.getFirst());
        System.out.println("max = "+mm.getSecond());

    }
}
class ArrayAlg{
    public static Pair<String> minMax(String[] a){
        if (a == null || a.length == 0){
            return null;
        }
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<>(min,max);
    }

    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }
}