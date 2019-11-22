package jvmtest.errer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-11-13 17:12
 */
public class OOMObject {

    private final static int size = 1024*1024;

    public static void main(String[] args) {
        List<OOMObject> objects = new ArrayList<>();
        while (true){
            objects.add(new OOMObject());
        }

    }
}
