package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-25 21:30
 */
public class TestInputOutputStream {

    @Test
    public void test1(){
        //1创建一个File类的对象
        File file = new File("d:/test/hello.txt");
        //创建一个FileInputStream类的对象
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[1204];
            //每次读入字节的长度
            int len;
            while ((len = fis.read(b)) != -1){
                String str = new String(b,0,len);
                System.out.println(str);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件不存在");
        }catch (IOException e){
            throw new RuntimeException("文件读取异常");
        }finally {
            try {
                if (fis != null){
                    fis.close();
                }
            }catch (IOException e){
                throw new RuntimeException("IO流关闭异常");
            }
        }
    }

    @Test
    public void test2(){
        //输出的文件可以不存在，会自动创建，若存在或自动覆盖；
        File file = new File("d:/test/hello1.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            String str = "fsacascascascasc";
            byte[] b = str.getBytes();
            fos.write(b,0,b.length);
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO流输出异常");
        }finally {
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    @Test
    public void test3(){
        //输出的文件可以不存在，会自动创建，若存在或自动覆盖；
        File file = new File("d:/test/hello.txt");
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(new File("d:/test/hello1.txt"));
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1){
                fos.write(b,0,len);
            }

        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO流输出异常");
        }finally {
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }

        }
    }

    public double count(int sum,double price){
        double count = sum * price;
        return count;
    }
}
