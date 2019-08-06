package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-29 20:02
 */
public class TestReadWriter {

    @Test
    public void reader(){
        File file = new File("D:/test/hello1.txt");
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            char[] c = new char[24];
            int len;
            while ((len = reader.read(c)) != -1){
                String str = new String(c,0,len);
                System.out.println(str);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO流异常");
        }finally {
            if (reader != null){
                try {
                    reader.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    @Test
    public void copy(){
        File file = new File("D:/test/hello1.txt");
        File file2 = new File("D:/test/hello22.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(file);
            fileWriter = new FileWriter(file2);
            char[] c = new char[1024];
            int len;
            while ((len = fileReader.read(c)) != -1){
                fileWriter.write(c,0,len);
            }
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                }catch (IOException e){
                    throw new RuntimeException("输出流关闭异常");
                }
            }
            if (fileReader != null){
                try {
                    fileReader.close();
                }catch (IOException e){
                    throw new RuntimeException("输入流关闭异常");
                }
            }
        }
    }

}
