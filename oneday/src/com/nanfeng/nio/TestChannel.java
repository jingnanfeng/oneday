package com.nanfeng.nio;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-03 8:59
 */

/**
 * 通道（Channel）:用于源节点和目标节点的连接。在NIO中负责缓冲区中数据的传输
 * channel本身不存储数据，因此需要配合缓冲区进行传输
 * 主要的实现类：
 *  java.nio,channels.Channel接口：
 *      FileChannle
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel
 * 获取通道
*   (1)Java针对支持通道的类提供了getChannel()方法
 *   本地IO
 *   FileInputStream/FileOutputStream
 *   RandomAccessFile
 *
 *   网路IO
 *   Socket
 *   ServerScoket
 *   DatagramSocket
 *  (2)在JDK1.7中静态方法open();
 *  (3)在JDK1.7中Files工具类中newByteChannel()方法
 *
 *  通道之间的数据传输
 *  transferFrom()
 *  transferTo()
 *
 *  分散（Scatter）与聚集（Gather）
 *  分散读取（Scattering Reads）:将通道的数据分散到多个缓冲区中
 *  聚集写入（Gathering Writes）:将多个缓冲区中的数据据聚集到通道中
 *
 *  字符集：Charset
 *  编码：字符串 -> 字符串
 *  解码 字符数组 -> 字符串
 *
 */

public class TestChannel {


    @Test
    public void test6() throws IOException{
        Charset  sc1 = Charset.forName("UTF-8");
        //获取编码器
        CharsetEncoder ce = sc1.newEncoder();
        //获取解码器
        CharsetDecoder cd = sc1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("ui三百VS代表");
        cBuf.flip();
        //编译
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 12; i++){
            System.out.println(bBuf.get());
        }
/*        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());*/

        System.out.println("--------------------------------");

        Charset sc2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = sc2.decode(bBuf);
        System.out.println(cBuf3.toString());

    }


    @Test
    public void test5(){
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String,Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }

    @Test
    public void test4() throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile("D:/test/hello1.txt","rw");
        //获取通道
        FileChannel channel1 = raf1.getChannel();
        //分散指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel1.read(bufs);

        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("-----------------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("D:/test/vvv.txt","rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);

        channel1.close();
        channel2.close();
    }

    /**
     * 通道之间的数据传输
     */
    @Test
    public void test3(){
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        long start = System.currentTimeMillis();
        try {
            //读通道
            inChannel = FileChannel.open(Paths.get("E:\\BaiduNetdiskDownload\\java核心\\java新技术\\nio/1. 尚硅谷_NIO_NIO 与 IO 区别.avi"),
                    StandardOpenOption.READ);
            //写通道
            outChannel = FileChannel.open(Paths.get("D:/test/1. 尚硅谷_NIO_NIO 与 IO 区别.avi"),
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.READ);

            //inChannel.transferTo(0,inChannel.size(),outChannel);
            outChannel.transferFrom(inChannel,0,inChannel.size());

        }catch (IOException e){
            throw new RuntimeException("IO流操作错误");
        }finally {
            if (outChannel != null){
                try {
                    outChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通过关闭异常");
                }
            }
            if (outChannel != null){
                try {
                    outChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通过关闭异常");
                }
            }

        }
    }

    /**
     * 直接缓冲区实现文件的复制
     */
    @Test
    public void test2(){

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        long start = System.currentTimeMillis();
        try {
            inChannel = FileChannel.open(Paths.get("E:\\BaiduNetdiskDownload\\java核心\\java新技术\\nio/1. 尚硅谷_NIO_NIO 与 IO 区别.avi"),
                    StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("D:/test/1. 尚硅谷_NIO_NIO 与 IO 区别.avi"),
                    StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.READ);
            //内存映射文件
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());
            //直接对缓冲区进行数据的读写
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);

        }catch (IOException e){
            throw new RuntimeException("IO操作异常");
        }finally {
            if (outChannel != null){
                try {
                    outChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
            if (inChannel != null){
                try {
                    inChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }


    @Test
    public void test1(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("E:/图片素材/1.jpg");
            fos = new FileOutputStream("D:/test/1.jpg");
            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //分配一个指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //讲通道中的数据存入缓冲求
            int i = 1;
            while (inChannel.read(buf) != -1){
                //切换成写取数据的模式
                buf.flip();
                //将缓冲区中的数据写入通道中
                outChannel.write(buf);
                //清空缓冲区
                buf.clear();
                System.out.println(i);
                i++;

            }

            //将缓冲区的数据写入通道
        }catch (FileNotFoundException e){
            throw new RuntimeException("文件找不到");
        }catch (IOException e){
            throw new RuntimeException("IO流操作异常");
        }finally {
            if (outChannel != null){
                try {
                    outChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
            if (inChannel != null){
                try {
                    inChannel.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
            if (fos != null){
                try {
                    fos.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
            if (fis != null){
                try {
                    fis.close();
                }catch (IOException e){
                    throw new RuntimeException("通道关闭异常");
                }
            }
        }
    }
}
