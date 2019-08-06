package com.nanfeng.io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-29 20:21
 */
public class TestBufferStream {

    @Test
    public void InpOutCopy(){
        File file = new File("D:/test/hello1.txt");
        File file2 = new File("D:/test/hello5.txt");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream(file2));
            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b,0,len);
            }
            bos.flush();
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO操作错误");
        }finally {
            if (bos != null){
                try {
                    bos.close();
                }catch (IOException e){
                    throw new RuntimeException("输出流关闭异常");
                }
            }
            if (bis != null){
                try {
                    bis.close();
                }catch (IOException e){
                    throw new RuntimeException("输入流关闭异常");
                }
            }
        }
    }

    @Test
    public void rwCopy(){
        File file = new File("D:/test/hello1.txt");
        File file2 = new File("D:/test/hello7.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter(file2));
            br = new BufferedReader(new FileReader(file));
            /*char[] c = new char[1024];
            int len = 0;
            while ((len = br.read(c)) != -1){
                bw.write(c,0,len);
            }
            bw.flush();*/

            String str;
            while ((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();

            }

        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO流操作异常");
        }finally {
            if (bw != null){
                try {
                    bw.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
            if (br != null){
                try {
                    br.close();
                }catch (IOException e){
                    throw new RuntimeException("IO流关闭异常");
                }
            }
        }
    }

}
