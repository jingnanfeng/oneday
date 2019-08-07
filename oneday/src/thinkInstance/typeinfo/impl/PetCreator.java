package thinkInstance.typeinfo.impl;

import thinkInstance.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 9:12
 */
public abstract class PetCreator {

    private Random rand =  new Random(47);

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet(){
        int n = rand.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        }catch (InstantiationException e){
            throw new RuntimeException();
        }catch (IllegalAccessException e){
            throw new RuntimeException();
        }
    }
    public Pet[] createArray(int size){
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }
    public ArrayList<Pet> arrayList(int size){
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result,createArray(size));
        return result;
    }

}
