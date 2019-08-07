package thinkInstance.map.containers;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-04 23:16
 */
public class SpringDetector {
    public static <T extends Groundhog> void detectSpring(Class<T> type) throws Exception{
        Constructor<T> ghog = type.getConstructor(int.class);
        Map<Groundhog,Prediction> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(ghog.newInstance(i),new Prediction());
        }
        System.out.println("map" + map);
        Groundhog gh = ghog.newInstance(3);
        System.out.println("look" + gh);
        if (map.containsKey(gh)){
            System.out.println(map.get(gh));
        }else {
            System.out.println("Key not found:"+gh);
        }
    }

    public static void main(String[] args) throws Exception {
        detectSpring(Groundhog.class);
        List<String> list = new ArrayList<>();
    }
}
