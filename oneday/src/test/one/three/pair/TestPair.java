package test.one.three.pair;
import test.one.extrnds.equals.Employee;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-03 15:00
 */
public class TestPair {
    public static void main(String[] args) {
        Manager ceo = new Manager("A",80000,2003,5,12);
        Manager cfo = new Manager("B",60000,2003,6,15);
        Pair<Manager> buddires = new Pair<>(ceo,cfo);
        printBuddies(buddires);
        ceo.setBouns(1000000);
        cfo.setBouns(20000000);
        Manager[] managers = {ceo,cfo};
        Pair<Employee> result = new Pair<>();
        minmaxBouns(managers,result);
        System.out.println(result.getFirst().getName());

    }
    public static void printBuddies(Pair<? extends Employee> p){
        Employee frist = p.getFirst();
        Employee second = p.getSecond();
        System.out.println(frist.getName()+" and "+second.getName()+" are buddies");
    }
    public static void minmaxBouns(Manager[] a,Pair<? super Manager> result){
        if (a.length == 0){
            return;
        }
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.getBouns() > a[i].getBouns()){
                min = a[i];
            }
            if (max.getBouns() < a[i].getBouns()){
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }
    public static void maxminBouns(Manager[] a,Pair<? super Manager> result){
        minmaxBouns(a,result);
        PairAlg.swapHelper(result);
    }
}
class PairAlg{
    public static boolean hashNull(Pair<?> p){
        return p.getFirst() == null || p.getSecond() ==null;
    }
    public static void swap(Pair<?> p) {
        swapHelper(p);
    }
    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setFirst(t);
    }
}