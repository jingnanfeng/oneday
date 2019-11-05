package test.one.two;

import java.util.Scanner;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-09 13:44
 */
public class Program {

    public static int getResult(int numberA,int numberB, String numberOperator) throws Exception {

        int numberC = 0;
        switch (numberOperator) {
            case "+":
                numberC = numberA + numberB;
                break;
            case "-":
                numberC = numberA - numberB;
                break;
            case "*":
                numberC = numberA * numberB;
                break;
            case "/":
                if (numberB != 0) {
                    numberC = numberA / numberB;
                } else {
                    throw new RuntimeException("除数不能为空");
                }
                break;
            default:
                throw new Exception("输入操作符不合法");
        }
        return numberC;

    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入数字A");
            Integer numberA = input.nextInt();

            System.out.println("请输入操作符");
            String numberOperator = input.next();

            System.out.println("请输入数字B");
            Integer numberB = input.nextInt();

            int numberC = getResult(numberA, numberB, numberOperator);

            System.out.println(numberC);
        }catch (Exception e){
            e.getMessage();
            e.printStackTrace();
        }


        /*------------------------------------------------------------------------------------------------*/
       /* Scanner input = new Scanner(System.in);
        try {
            System.out.println("请输入数字A");
            Integer numberA = input.nextInt();

            System.out.println("请输入操作符");
            String numberOperator = input.next();

            System.out.println("请输入数字B");
            Integer numberB = input.nextInt();

            Integer numberC = null;

            switch (numberOperator){
                case "+":
                    numberC = numberA + numberB;
                    break;
                case "-":
                    numberC = numberA - numberB;
                    break;
                case "*":
                    numberC = numberA * numberB;
                    break;
                case "/":
                    if (numberB !=null){
                        numberC = numberA / numberB;
                    }else {
                        throw new RuntimeException("除数不能为空");
                    }
                    break;
               default:
                   throw new Exception("输入操作符不合法");

            }
            System.out.println(numberC);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }*/


        /*-----------------------------------------------------------------------------*/

        /*Scanner input = new Scanner(System.in);
        System.out.println("请输入数字a:");
        Integer a = input.nextInt();

        System.out.println("请输入操作符（+,-,*./）");
        String b = input.next();

        System.out.println("请输入数字c:");
        Integer c = input.nextInt();
        Integer d = null;
        if ("+".equals(b)){
            d = a + c;
        }
        if ("-".equals(b)){
            d = a - c;
        }
        if ("*".equals(b)){
            d = a * c;
        }
        if ("/".equals(b)){
            d = a / c;
        }
        System.out.println(d);
*/
    }
}
