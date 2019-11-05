package test.one.extrnds;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-04-23 15:14
 */
public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Mot",800000,2003,12,15);
        boss.setBonus(20000);

        Employee[] staff = new Employee[3];

        staff[0] = boss;
        staff[1] = new Employee("Harry",50000,2013,10,1);
        staff[2] = new Employee("Terry",30000,3019,3,4);

        for (Employee employee : staff) {
            System.out.println("name="+employee.getName()+
                    ",salary="+employee.getSalary());
        }
    }
}


