package cn.com.nanfeng.pattern.proxy_pattern;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-15 14:24
 */

/**
 * 这是一个没有代理的代码：假设最求者和女孩并不认识
 */

/**
 * 这是一个最求者
 */
class Pursuit{

    protected  SchoolGirl schoolGirl;

    public Pursuit(SchoolGirl schoolGirl){
        this.schoolGirl = schoolGirl;
    }

    public void giveDolls(){
        System.out.println(schoolGirl.getName()+",送给你一个洋娃娃");
    }
    public void giveFlowers(){
        System.out.println(schoolGirl.getName()+",送给你鲜花");
    }
    public void giveChocolate(){
        System.out.println(schoolGirl.getName()+",送给你巧克力");
    }



}
class SchoolGirl{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
public class NoProxyApplication {
    public static void main(String[] args) {
        SchoolGirl schoolGirl = new SchoolGirl();
        schoolGirl.setName("小红");
        Pursuit pursuit = new Pursuit(schoolGirl);

        pursuit.giveChocolate();
        pursuit.giveDolls();
        pursuit.giveFlowers();
    }
}
