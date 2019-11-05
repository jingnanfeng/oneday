package test.one.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-03-21 21:25
 */
public class HeapOOM {

    static class OOMObject{
        public static void main(String[] args) {
            List<OOMObject> list = new ArrayList<>();
            while (true){
                list.add(new OOMObject());
            }
        }
    }
}
