package thinkInstance.typeinfo.impl;

import thinkInstance.typeinfo.pets.*;

import java.util.HashMap;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 20:22
 */
public class PetCount {
    static class PetCounter extends HashMap<String,Integer>{
        public void count(String type){
            Integer quantity = get(type);
            if (quantity == null){
                put(type,1);
            }else {
                put(type,quantity+1);
            }
        }
    }
    public static void countPets(PetCreator creator){
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName()+" ");
            if (pet instanceof Pet){
                counter.count("Pet");
            }
            if (pet instanceof Dog){
                counter.count("Dog");
            }
            if (pet instanceof Mutt){
                counter.count("Mutt");
            }
            if (pet instanceof Pug){
                counter.count("pug");
            }
            if (pet instanceof Cat){
                counter.count("cat");
            }
        }
        System.out.print("");
        System.out.print(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}
