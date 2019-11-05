package test.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-20 14:32
 */
public class CompoundInterest {

    public static void main(String[] args) {

        //start rate
        final double STARTRATE = 10;
        //nrates
        final int NRATES = 6;
        //nyears
        final int NYEARS = 10;
        double [] interestRate = new double[NRATES];
        for (int j = 0;j < interestRate.length;j++) {
            interestRate[j] = (STARTRATE + j) / 100.0;
        }
        double[][] balance = new double[NYEARS][NRATES];
        for (int i= 0;i < balance.length; i++){
            for (int j = 0;j<balance[i].length;j++){

            }
        }
    }

}
