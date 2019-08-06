package cn.com.nanfeng.pattern.factory;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-09 15:12
 */

/**
 * 运算的父类
 */
class Operation {

    private int numberA;
    private int numberB;

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public int getnumberB() {
        return numberB;
    }

    public void setnumberB(int numberB) {
        this.numberB = numberB;
    }

    public int getResult(){
        int result = 0;
        return result;
    }
}

/**
 * 加法运算
 */
class AddOperation extends Operation{

    @Override
    public int getResult() {
        int result;
        result = getNumberA() + getnumberB();
        return result;
    }
}

/**
 * 减法运算
 */
class DelOperation extends Operation{

    @Override
    public int getResult() {
        int result;
        result = getNumberA() - getnumberB();
        return result;
    }
}

/**
 * 乘法运算
 */
class MulOperation extends Operation{

    @Override
    public int getResult() {
        int result;
        result = getNumberA() * getnumberB();
        return result;
    }
}

/**
 * 除法运算
 */
class DivOperation extends Operation{

    @Override
    public int getResult() {
        int result;
        if (getnumberB()==0){
            throw new RuntimeException("除数不能为0");
        }
        result = getNumberA() / getnumberB();
        return result;
    }
}

public class ProgramNew{


    public static Operation createOperation(String operate){

        Operation operation = null;
        switch (operate){
            case "+":
                operation = new AddOperation();
                break;
            case "-":
                operation = new DelOperation();
                break;
            case "*":
                operation = new MulOperation();
                break;
            case "/":
                operation = new DivOperation();
                break;
                default:
                    new RuntimeException("该操作符不符合规则");
        }
        return operation;
    }

    public static void main(String[] args) {

        Operation operation = new Operation();

        operation = createOperation("+");

        operation.setNumberA(6);
        operation.setnumberB(7);
        int result = operation.getResult();
        System.out.println(result);
    }
}