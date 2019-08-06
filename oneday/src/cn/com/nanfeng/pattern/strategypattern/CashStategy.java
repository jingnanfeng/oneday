package cn.com.nanfeng.pattern.strategypattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-10 11:43
 */

/**
 * 策略模式：它定义的算法家族，分别封装起来，让
 * 他们之间可以相互替换，此模式让算法的变化，不会影响到使用算法的客户。
 */

/**
 * 创建策略上下文类
 */
class CashContext{

    private CashSuper cashSuper;

    public CashContext(String type){
            switch (type){
                case "正常":
                    cashSuper = new CashNormol();
                    break;
                case "打八折":
                    cashSuper = new CashRebate(0.8);
                    break;
                case"满300减100":
                    cashSuper = new CashReturn(300,100);
                    break;
                default:
                    System.out.println("暂无此活动");
            }
    }

    public double gteResult(double money){

        return cashSuper.acceptCase(money);
    }

}

/**
 * 优惠的父类
 */
abstract class CashSuper{

    public abstract double acceptCase(double money);

}

/**
 * 不优惠的子类
 */
class CashNormol extends CashSuper {

    @Override
    public double acceptCase(double money) {
        return money;
    }
}

/**
 * 打折的子类
 */
class CashRebate extends CashSuper {

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
class CashReturn extends CashSuper {

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

public class CashStategy {

    public static void main(String[] args) {
        CashContext cashContext = new CashContext("满300减100");
        double result = cashContext.gteResult(200);
        System.out.println(result);
    }

}
