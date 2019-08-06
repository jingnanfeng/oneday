package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Date;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-24 21:18
 */
public class TestFile {
    /**
     * 路径分为两种，绝对路径，相对路径
     */
    @Test
    public void test1(){
        File file = new File("d:/test/hello");
        File file1 = new File("d:\\test\\io");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getParent());
        System.out.println("----------------------");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());
        System.out.println("--------------");
        System.out.println(file.renameTo(file1));
    }

    @Test
    public void test2(){
        File file = new File("d:/test/hello.txt");
        File file1 = new File("d:\\test\\io");
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(new Date(file.lastModified()));
        System.out.println(file.length());
    }
    @Test
    public void test3(){
        File file = new File("d:/test/hello.txt");
        System.out.println(file.delete());
        if (!file.exists()){
            try {
                file.createNewFile();
            }catch (Exception e){
                throw new RuntimeException("创建文件失败");
            }
        }
        File file1 = new File("d:\\test\\io2\\op");
        if (!file1.exists()){
            file1.mkdirs();
        }
    }
    @Test
    public void test4(){
        File file = new File("d:/test");
        String[] files = file.list();
        for (String s : files) {
            System.out.println(s);
        }
        File[] files1 = file.listFiles();
        for (File file1 : files1) {
            System.out.println(file1);
        }
    }

}
