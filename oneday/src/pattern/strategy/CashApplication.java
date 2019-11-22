package pattern.strategy;

/**
 * @author liutao
 * @Title 使用策略模式实现超市收银系统
 * @Description
 * @date 2019-11-19 11:16
 */

import java.util.Scanner;

/**
 * 收银的父接口
 */
interface CashSuper{
    /**
     * 收钱
     * @return
     */
    double acceptCash(double money);
}

/**
 * 正常日子，没有优惠活动
 */
class CashNomal implements CashSuper{


    @Override
    public double acceptCash(double money) {
        return money;
    }
}

/**
 * 遇到节假日，减免活动
 */
class CashReturn implements CashSuper{

    private double price;
    private double derate;

    public CashReturn(double price,double derate){
        this.price = price;
        this.derate = derate;
    }

    @Override
    public double acceptCash(double money) {
        if (money > price){
            return money - derate;
        }
        return money;
    }
}

/**
 * 遇到周年庆，全场统一8折
 */
class CashRebate implements CashSuper{

    private double rebate;

    public CashRebate(double rebate){
        this.rebate = rebate;
    }

    @Override
    public double acceptCash(double money) {
        return money * rebate;
    }
}

/**
 * 实现具体的策略模式
 */
class CashContext{

    private CashSuper cashSuper;


    //初始化时传入具体的策略模式
    public CashContext(CashSuper cashSuper){
        this.cashSuper = cashSuper;
    }

    //实现具体的策略模式
    public double getResult(double money){
        return cashSuper.acceptCash(money);
    }
}

public class CashApplication {

    public static CashContext strategyMethod(Integer strategy){
        CashContext cashContext = null;
        switch (strategy){
            case 1:
                cashContext = new CashContext(new CashNomal());
                break;
            case 2:
                cashContext = new CashContext(new CashReturn(300,100));
                break;
            case 3:
                cashContext = new CashContext(new CashRebate(0.8));
                break;
                default:
                    throw new RuntimeException("暂无此活动");

        }
       return cashContext;
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入要使用的策略");
        int i = input.nextInt();
        CashContext cashContext = strategyMethod(i);
        double result = cashContext.getResult(500);
        System.out.println(result);

    }
}
