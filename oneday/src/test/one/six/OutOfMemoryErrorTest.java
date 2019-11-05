package test.one.six;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-10-28 13:56
 */
public class OutOfMemoryErrorTest {
    private Map<String,Object> object;

    public void methom(){

        Map<String,Object> resuMap = new HashMap<>();
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");
        resuMap.put("aa","aa");

        object = new HashMap<>(resuMap);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }

    public static void main(String[] args) {
        OutOfMemoryErrorTest test = new OutOfMemoryErrorTest();
        test.methom();
    }
}
