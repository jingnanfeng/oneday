package test.one.extrnds;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-25 15:30
 */
public class Change {

    public static double max(double... values){

        double largest = Double.NEGATIVE_INFINITY;

        for (double value : values) {
            if (value > largest){
                largest = value;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        double max = Change.max(1.1, 1.3, 0.5, 15, 6, 8.0);
        System.out.println(max);
    }
}
