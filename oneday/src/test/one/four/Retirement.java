package test.one.four;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-15 16:11
 */

import org.junit.jupiter.api.Test;

/**
 * 计算多长时间才能存储够一定数量的退休金
 */

public class Retirement {
    /*public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("需要存储多少钱的退休金");
        double goal = input.nextDouble();

        System.out.println("你每年存多少钱");
        double payment = input.nextDouble();

        System.out.println("每年的利率");
        double interestRate = input.nextDouble();

        double balance = 0;
        int year = 0;

        while (balance < goal){
            balance += payment;
            double interrest = balance * interestRate / 100;
            balance += interrest;
            year++;
        }
        System.out.println("一共需要"+year+"年");
    }*/
   /* public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("你每年存多少钱");
        double payment = input.nextDouble();

        System.out.println("利率为：");
        double interestRete = input.nextDouble();

        double balance = 0;
        double year = 0;
        String option;

        do{
            balance += payment;
            double interest = balance * interestRete / 100;
            balance += interest;

            year++;
            System.out.println(year);
            System.out.println(balance);

            System.out.println("是否已经可以退休（Y/N）");
            option = input.next();
        }while (option.equals("N"));

    }*/
    public static final int A = 10;
   @Test
    public void test1(){


       for (int i = A; i > 0; i--){
           System.out.println(i);
       }
       System.out.println("-----------------------------");
   }
}
