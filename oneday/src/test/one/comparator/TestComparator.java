package test.one.comparator;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-29 17:59
 */
class Employee implements Comparable{
    private Integer age;

    public Employee(Integer age){
        this.age = age;
    }
    public Employee(){

    }

    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
        return this.age.compareTo(((Employee) o).age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                '}';
    }
}


public class TestComparator {
    public static void main(String[] args) {
        int len = 20;
        for (int i = 0; i < len; i++) {
            Employee e = new Employee(i);
        }

    }

}
