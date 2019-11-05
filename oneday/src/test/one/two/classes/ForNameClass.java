package test.one.two.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-19 9:47
 */
public class ForNameClass extends PetCreator {

    private static List<Class<? extends Person>> types =
            new ArrayList<>();

    private static String[] typeNames = {
            "com.nanfeng.two.classes.Person",
           "com.nanfeng.two.classes.Man",
           "com.nanfeng.two.classes.Woman"
    };

    @SuppressWarnings("unchecked")
    private static void loader(){
        try {
            for (String typeName : typeNames) {
                types.add((Class<? extends Person>)Class.forName(typeName));
            }
        }catch (ClassNotFoundException e){
            throw new RuntimeException();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Person>> types() {
        return types;
    }
}
