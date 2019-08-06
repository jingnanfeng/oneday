package cn.com.nanfeng.pattern.factory.simplyfactory;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-16 9:48
 */

/**
 * 抽象父类，一个计算机类
 */
class Operation{

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

    public Integer getResult(){
        int result = 0;
        return result;
    }
}

/**
 * 具体的计算类,加法类
 */
class AddOperation extends Operation{

    @Override
    public Integer getResult() {
        int result = getNumberA() + getNumberB();
        return result;
    }
}

/**
 * 具体的计算类，减法类
 */
class DelOperation extends Operation{
    @Override
    public Integer getResult() {
        int result = getNumberA() - getNumberB();
        return result;
    }
}

/**
 * 具体的除法类
 */
class DivOperation extends Operation{
    @Override
    public Integer getResult() {
        if (getNumberB()==0){
            throw new RuntimeException("除数不能为空");
        }
        int result = getNumberA() / getNumberB();
        return result;
    }
}

/**
 * 具体的乘法类
 */
class MulOperation extends Operation{
    @Override
    public Integer getResult() {
        int result = getNumberA() * getNumberB();
        return result;
    }

}


public class Application {

    public static Operation createOption(String type){

        Operation operation = null;

        switch (type){
            case "加法":
               operation = new AddOperation();
               break;
            case "减法":
                operation = new DelOperation();
                break;
            case "除法":
                operation = new DivOperation();
                break;
            case "乘法":
                operation = new MulOperation();
                break;
                default:
                    new Exception("暂无此操作");
        }
        return operation;
    }

    public static void main(String[] args) {
        Operation operation = createOption("加法");
        operation.setNumberB(4);
        operation.setNumberA(6);
        Integer result = operation.getResult();
        System.out.println(result);


    }

}
