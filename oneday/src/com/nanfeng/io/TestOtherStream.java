package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-31 21:19
 */
public class TestOtherStream {

    /**
     * 打印流
     * 字节流:PrintStream
     * 字符流：PrintWrite
     */
    @Test
    public void printStream(){
        FileOutputStream fos = null;
        try {
            File filepath = new File("d:/IO");
            if (!filepath.exists()){
                filepath.mkdirs();
            }
            File file = new File(filepath + filepath.separator+"test.txt");
            if (!file.exists()){
                file.createNewFile();
            }
            fos = new FileOutputStream(file);

            PrintStream ps = new PrintStream(fos,true);
            if (ps != null){
                System.setOut(ps);
            }
            for (int i = 0; i < 255; i++) {
                System.out.print((char)i);
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
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

    /**
     * 数据流：用来处理数据类型的
     * DataInputStream
     * DataOutputStream
     * 分别"套接"在InputStream 和 OutPutStream
     */
    @Test
    public void testData(){
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream("d:/test/ccc.txt");
            dos = new DataOutputStream(fos);
            dos.writeUTF("我VS v哦i是v哦稍等v好i");
            dos.writeBoolean(true);
            dos.writeLong(1513132351);
        }catch (IOException e){
            throw new RuntimeException("IO流操作异常");
        }finally {
            if (dos != null){
                try {
                    dos.close();
                }catch (IOException e){
                   throw new RuntimeException("IO流关闭异常");
                }
            }
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
    public void test2(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("d:/test/ccc.txt"));
            /*byte[] b = new byte[20];
            int len;
            while ((len = dis.read(b)) != -1){
                System.out.println(new String(b,0,len));
            }*/
            String str =  dis.readUTF();
            boolean b = dis.readBoolean();
            long l = dis.readLong();
            System.out.println(str +" "+ b + "" + l);
        }catch (IOException e){
            throw new RuntimeException("IO流关闭异常");
        }finally {
            if (dis != null){
                try {
                    dis.close();
                }catch (IOException e){
                    throw new RuntimeException("IO关闭异常");
                }
            }
        }
    }
}
