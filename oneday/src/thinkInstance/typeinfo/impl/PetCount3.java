package thinkInstance.typeinfo.impl;

import thinkInstance.typeinfo.pets.Pet;

import java.util.LinkedHashMap;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 21:10
 */
public class PetCount3 {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>,Integer>{
        public PetCounter(){
            super();
        }
        public void count(Pet pet){

        }
    }
}
