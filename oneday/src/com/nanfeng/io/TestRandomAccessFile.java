package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-01 20:57
 */
public class TestRandomAccessFile {
    @Test
    public void test(){
        RandomAccessFile read = null;
        RandomAccessFile write = null;
        try {
            read = new RandomAccessFile(new File("d:/test/hello.txt"),"r");
            write = new RandomAccessFile(new File("d:/test/ggg.txt"),"r");

            byte[] b = new byte[1024];
            int len;
            while ((len = read.read(b)) != -1){
                write.write(b,0,len);
            }
        }catch (IOException e){
           // throw new RuntimeException("IO操作异常");
            e.printStackTrace();
        }finally {
            if (write != null){
                try {
                    write.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
            if (read != null){
                try {
                    read.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

    @Test
    public void test2(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:/test/hello.txt","rw");
            raf.seek(32);
            raf.write("vbuisbvisdbvsbdviu".getBytes());

        }catch (IOException e){
            throw new RuntimeException("IO流关闭异常");
        }finally {
            if (raf != null){
                try {
                    raf.close();
                }catch (IOException e){
                    throw new RuntimeException("IO操作异常");
                }
            }
        }

    }

    @Test
    public void test3(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:/test/hello.txt","rw");
            raf.seek(5);
            String str = raf.readLine();
            long l = raf.getFilePointer();
            System.out.println(l);
            raf.seek(5);
            raf.write("vbuisbvisdbvsbdviu".getBytes());
            raf.write(str.getBytes());

        }catch (IOException e){
            throw new RuntimeException("IO流关闭异常");
        }finally {
            if (raf != null){
                try {
                    raf.close();
                }catch (IOException e){
                    throw new RuntimeException("IO操作异常");
                }
            }
        }
    }

    @Test
    public void test5(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("d:/test/hello.txt","rw");
            raf.seek(5);
            byte[] b = new byte[10];
            int len;
            StringBuffer sb = new StringBuffer();
            while ((len = raf.read(b)) != -1){
                sb.append(new String(b,0,len));
            }
            raf.seek(5);
            raf.write("vbuisbvisdbvsbdviu".getBytes());

            raf.write(sb.toString().getBytes());

        }catch (IOException e){
            throw new RuntimeException("IO流关闭异常");
        }finally {
            if (raf != null){
                try {
                    raf.close();
                }catch (IOException e){
                    throw new RuntimeException("IO操作异常");
                }
            }
        }
    }
}
