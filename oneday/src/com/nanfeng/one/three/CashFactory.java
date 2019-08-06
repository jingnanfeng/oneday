package com.nanfeng.one.three;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 9:45
 */

/**
 * 利用工厂模式来完成商城打折活动
 */

/**
 * 优惠的父类
 */
abstract class CashSuper{

    public abstract double acceptCase(double money);

}

/**
 * 不优惠的子类
 */
class CashNormol extends CashSuper{

    @Override
    public double acceptCase(double money) {
        return money;
    }
}

/**
 * 打折的子类
 */
class CashRebate extends CashSuper{

    private double moneyRebate;

    public CashRebate(double moneyRebate){
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCase(double money) {
        return money * moneyRebate;
    }
}

/**
 * 减免的子类
 */
class CashReturn extends CashSuper{

    /**
     * 减免的条件
     */
    private double moneyCondition;
    /**
     *  减免的钱
     */
    private double moneyReturn;


    public CashReturn(double moneyCondition,double moneyReturn){

        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;

    }

    @Override
    public double acceptCase(double money) {

        double result = money;
        if (money >= moneyCondition){
            result = money - moneyReturn;
        }
        return result;
    }
}

public class CashFactory {

    public CashSuper createAcceptCash(String type){
        CashSuper cashSuper = null;
        switch (type){
            case "正常":
                cashSuper = new CashNormol();
                break;
            case "打八折":
                cashSuper = new CashRebate(0.8);
                break;
            case "满300减100":
                cashSuper = new CashReturn(300,100);
                break;
                default:
                    System.out.println("暂无次优惠");
        }
        return cashSuper;
    }

    public static void main(String[] args) {
        CashFactory cashFactory = new CashFactory();
        CashSuper cashSuper = cashFactory.createAcceptCash("打八折");
        double result = cashSuper.acceptCase(500);
        System.out.println(result);

    }

}
