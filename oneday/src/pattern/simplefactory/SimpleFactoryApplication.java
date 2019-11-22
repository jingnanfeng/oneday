package pattern.simplefactory;

/**
 * @author liutao
 * @Title 简单工厂模式
 * @Description 属于类的创新性模式，又称静态工厂方法模式，
 * 是通过专门定义一个类来负责创建其他类的实例，被创建的实例通常都具有共同的父类
 * @date 2019-11-18 17:53
 */


/**
 * 计算机运算类
 */
abstract class Operation{

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

    public abstract double getResult();

}

/**
 * 加法类
 */
class AddOperation extends Operation{

    @Override
    public double getResult() {
        double addResult =(double)getNumberA()+getNumberB();
        return addResult;
    }
}

/**
 * 减法类
 */
class SubOperation extends Operation{

    @Override
    public double getResult() {
        double subResult = (double)getNumberA()-getNumberB();
        return subResult;
    }
}

/**
 * 乘法类
 */
class MulOperation extends Operation{
    @Override
    public double getResult() {
        double mulResult = (double)getNumberA() * getNumberB();
        return mulResult;
    }
}

/**
 * 除法类
 */
class DivOperation extends Operation{
    @Override
    public double getResult() {
        if (getNumberB() == 0){
            throw new RuntimeException("除数不能为0");
        }
        double divResult = (double) getNumberA() / getNumberB();
        return divResult;
    }
}

/**
 * 运算工厂类
 */
class OperationFactory {
    public static Operation createOperate(String operate){

        Operation operation = null;

        switch (operate){
            case "+":
                operation = new AddOperation();
                break;
            case "-":
                operation = new SubOperation();
                break;
            case "*":
                operation = new MulOperation();
                break;
            case "/":
                operation = new DivOperation();
                break;
            default:
                throw new RuntimeException("不支持" + operate + "运算");

        }
        return operation;
    }
}

public class SimpleFactoryApplication {

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperate("+");
        operation.setNumberA(5);
        operation.setNumberB(10);
        double result = operation.getResult();
        System.out.println(result);
    }
}
