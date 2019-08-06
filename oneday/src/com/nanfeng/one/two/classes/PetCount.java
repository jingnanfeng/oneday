package com.nanfeng.one.two.classes;

import java.util.HashMap;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 9:57
 */
public class PetCount {

    static class PetCounter extends HashMap<String,Integer> {
        public void count(String type){
            Integer quantity = get(type);
            if (quantity == null){
                put(type,1);
            }else {
                put(type , quantity+1);
            }
        }
    }
    public static void countPets(PetCreator creator){

        PetCounter counter = new PetCounter();

        for (Person person : creator.createArray(20)) {
            System.out.print(person.getClass().getSimpleName()+" ");
            if (person instanceof Person){
                counter.count("person");
            }
            if (person instanceof Man){
                counter.count("man");
            }
            if (person instanceof Woman){
                counter.count("woman");
            }
        }
        System.out.println();
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameClass());
    }

}
