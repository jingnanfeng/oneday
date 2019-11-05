package test.one.two.classes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 10:14
 */
public class LiteralPetCreator extends PetCreator{

    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Person>> alltypes =
            Collections.unmodifiableList(Arrays.asList(Person.class,Woman.class,Man.class));

    private static final List<Class<? extends Person>> types =
            alltypes.subList(alltypes.indexOf(Woman.class),alltypes.size());
    @Override
    public List<Class<? extends Person>> types(){
        return types;
    }

    public static void main(String[] args) {
        System.out.println(types);
    }

}
