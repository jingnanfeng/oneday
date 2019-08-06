package com.nanfeng.thinkInstance.typeinfo.impl;

import com.nanfeng.thinkInstance.typeinfo.pets.Pet;

import java.util.ArrayList;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 20:48
 */
public class Pets {
    public static final PetCreator creator = new LiteralPetCreator();

    public static Pet randomPet(){
        return creator.randomPet();
    }

    public static Pet[] createArray(int size){
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size){
        return creator.arrayList(size);
    }
}
