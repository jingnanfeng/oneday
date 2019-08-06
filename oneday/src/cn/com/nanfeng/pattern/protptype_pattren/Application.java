package cn.com.nanfeng.pattern.protptype_pattren;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-20 10:24
 */

/**
 * 这是一个简历的方法
 */
class Resume{
    private String name;
    private String sex;
    private String age;
    private String timeArea;
    private String company;

    public Resume(String name){
        this.name = name;
    }

    /**
     * 设置个人信息
     */
    public void setPersonalInfo(String sex,String age){
        this.sex = sex;
        this.age = age;
    }

    /**
     * 设置工作经历
     */
    public void etWorkExperience(String timeArea,String company){
        this.timeArea = timeArea;
        this.company = company;
    }

    /**
     * 显示
     */
    public void distory(){
        System.out.println("基本信息 "+name+" "+sex+" "+age);
        System.out.println("工作信息 "+timeArea+" "+company);
    }

}

public class Application {
    public static void main(String[] args) {
        /*Resume a1 = new Resume("大鸟");
        a1.setPersonalInfo("男","29");
        a1.etWorkExperience("1998-2000","xx公司");
        Resume a2 = new Resume("大鸟");
        a2.setPersonalInfo("男","29");
        a2.etWorkExperience("1998-2000","xx公司");
        Resume a3 = new Resume("大鸟");
        a3.setPersonalInfo("男","29");
        a3.etWorkExperience("1998-2000","xx公司");

        a1.distory();
        a2.distory();
        a3.distory();*/
        Resume a1 = new Resume("大鸟");
        a1.setPersonalInfo("男","29");
        a1.etWorkExperience("1998-2000","xx公司");
        Resume a2 = a1;
        Resume a3 = a2;
        Resume a4 = a3;

        a1.distory();
        a2.distory();
        a3.distory();
        a4.distory();

    }

}
