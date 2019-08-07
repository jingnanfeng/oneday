package thinkInstance.typeinfo.impl;


import thinkInstance.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 9:27
 */
public class ForNameCreator extends PetCreator {

    private static List<Class<? extends Pet>> types =
            new ArrayList<>();
    private static String[] typeNames = {
            "com.nanfeng.typeinfo.pets.Cat",
            "com.nanfeng.typeinfo.pets.Dog",
            "com.nanfeng.typeinfo.pets.Cymric",
            "com.nanfeng.typeinfo.pets.Manx",
            "com.nanfeng.typeinfo.pets.Mouse",
            "com.nanfeng.typeinfo.pets.Mutt",
            "com.nanfeng.typeinfo.pets.Pat",
            "com.nanfeng.typeinfo.pets.Pug",
    };
    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>)Class.forName(name));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }

    }
    static {
        loader();
    }
    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
