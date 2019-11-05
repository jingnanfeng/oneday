package test.one.two.classes;

import java.util.ArrayList;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 10:29
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Person random(){
        return creator.randomPerson();
    }

    public static Person[] createArray(int size){
        return creator.createArray(size);
    }

    public static ArrayList<Person> arrayList(int size){
        return creator.arrayList(size);
    }
}
