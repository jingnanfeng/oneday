package test.one.two.classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 9:38
 */
public abstract class PetCreator {

    private Random random = new Random(47);

    public abstract List<Class<? extends Person>> types();

    public Person randomPerson(){
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        }catch (InstantiationException e){
            throw new RuntimeException();
        }catch (IllegalAccessException e){
            throw new RuntimeException();
        }
    }

    public Person[] createArray(int size){
        Person[] result = new Person[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPerson();
        }
        return result;
    }

    public ArrayList<Person> arrayList(int size){
        ArrayList<Person> result = new ArrayList<>();
        Collections.addAll(result,createArray(size));
        return result;
    }

}
