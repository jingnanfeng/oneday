package jvmtest;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-09 11:51
 */
public class Person {

    static {
        System.out.println("entry static method");
    }

    public Person(){
        System.out.println("entry method");
    }

    private String name;

    private boolean isMan = true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isMan=" + isMan +
                '}';
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("111");
   }

}
