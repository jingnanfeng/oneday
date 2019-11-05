package test.one.extrnds.absatrct;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 17:29
 */
public class Student extends Person {

    private String major;

    public Student(String name,String major){
        super(name);
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in"+major;
    }
}
