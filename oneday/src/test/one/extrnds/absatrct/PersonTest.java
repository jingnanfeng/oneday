package test.one.extrnds.absatrct;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 17:32
 */
public class PersonTest {

    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Harry",20000,1565,10,1);
        people[1] = new Student("Morry","computer scrience");

        for (Person person : people) {
            System.out.println(person.getName()+" "+person.getDescription());
        }
    }
}
