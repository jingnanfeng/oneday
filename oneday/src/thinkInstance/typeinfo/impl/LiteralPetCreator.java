package thinkInstance.typeinfo.impl;

import thinkInstance.typeinfo.pets.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-17 20:38
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Pug.class, Manx.class
    ));

    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),allTypes.size());

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }
}
