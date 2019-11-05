package test.one.two.TestArrays;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-05-17 17:11
 */
public class TestMap {
    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");
        stringList.add("1");

        Collections.unmodifiableList(stringList);
    }

    public void test() throws Exception{
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("E:\\aaa.txt"));
        }catch (Exception e) {
            throw new FileNotFoundException("文件找不到");
        }
    }
}
