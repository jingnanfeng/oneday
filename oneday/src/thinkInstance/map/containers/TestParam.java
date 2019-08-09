package thinkInstance.map.containers;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-09 8:40
 */
public class TestParam {

    //容器中的元素个数
    public final int size;
    //测试迭代的次数
    public final int loops;

    public TestParam(int size,int loops){
        this.loops = loops;
        this.size = size;
    }
    public static TestParam[] array(int... values){
        int size = values.length/2;
        TestParam[] result = new TestParam[size];
        int n = 0;
        for (int i = 0; i < size; i++){
            result[i] = new TestParam(values[n++],values[n++]);
        }
        return result;
    }

    public static TestParam[] array(String[] values){
        int[] vals = new int[values.length];
        for (int i = 0; i < vals.length; i++) {
            //decode将字符串
            vals[i] = Integer.decode(values[i]);
        }
        return array(vals);
    }
}
