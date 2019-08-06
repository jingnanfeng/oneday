package cn.com.nanfeng.pattern.factory.factory;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-18 8:58
 */

/**
 * 采用内部类和工厂相结合，使代码变得更优雅
 */
 abstract class Operation1{
    private Integer numberA;
    private Integer numberB;

    public Integer getNumberA() {
        return numberA;
    }

    public void setNumberA(Integer numberA) {
        this.numberA = numberA;
    }

    public Integer getNumberB() {
        return numberB;
    }

    public void setNumberB(Integer numberB) {
        this.numberB = numberB;
    }

    //计算的抽象类
    public abstract Integer getResult();


}

/**
 * 抽象工厂类
 */
interface OperationFactory{

    Operation1 getOperation();
}

/**
 * 具体的加法实现类
 */
class AddOperation extends Operation1{

    public static OperationFactory operationFactory =
            new OperationFactory() {
                @Override
                public Operation1 getOperation() {
                    return new AddOperation();
                }
            };

    @Override
    public Integer getResult() {
        Integer result = getNumberA() + getNumberB();
        return result;
    }
}

/**
 * 具体的减法实现类
 */
class DivOperation1 extends Operation1{
    @Override
    public Integer getResult() {
        return getNumberA() - getNumberB();
    }

    public static OperationFactory operationFactory =
            new OperationFactory() {
                @Override
                public Operation1 getOperation() {
                    return new DivOperation1();
                }
            };
}



public class AnonymousApplication {

    public Integer createOperation(OperationFactory fact){
        Operation1 operation1 = fact.getOperation();
        operation1.setNumberA(5);
        operation1.setNumberB(6);
        Integer result = operation1.getResult();
        return result;
    }

    public static void main(String[] args) {

        AnonymousApplication application = new AnonymousApplication();
        Integer result = application.createOperation(AddOperation.operationFactory);
        System.out.println(result);

        Integer result2 = application.createOperation(DivOperation1.operationFactory);
        System.out.println(result2);


    }
}
