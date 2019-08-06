package com.nanfeng.nio;

/**
 * @author liutao
 * @Title Buffer 在Java中负责数据的存储，缓冲求就是数组，
 * 用于存储不同数据类型的数据
 * @Description
 * @date 2019-08-02 21:39
 */

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;

/**
 * 根据数据类型不同（boolean 除外）
 *  ByteBuffer
 *  CharBuffer
 *  ShortBuffer
 *  IntBuffer
 *  FloatBuffer
 *  DoubleBuffer
 *  LongBuffer
 * 缓冲区存取数据两个核心的方法
 *  put():存入数据到缓冲区
 *  get():获取缓冲区的数据
 *  filp():方法切换模式，同时position回到首位，limit变成原来position的位置
 * 缓冲区的四个核心属性
 *  capacity:容量，表示缓冲区中最大存取数据的容量，一旦声明不能修改
 *  limit: 界限，表示缓冲区可以操作数据的大小（limit后面的数据是不能读写的）
 *  position:位置，表示缓冲区中正在操作数据的位置
 *  mark:记录position的位置，可以通过reset恢复到mark的位置
 *  0 <= mark <= position <= limit <= capacity
 *  直接缓冲区与非直接缓冲区 ：
 *      非直接缓冲区：通过allocate()方法分配缓冲区，讲缓冲区建立在JVM的内存中
 *      直接缓冲区：通过allocateDirect()方法分配直接缓冲区，讲缓冲区之间 建立在物理内存中，可以提高效率
 */
public class TestBuffer {

    @Test
    public void test3(){
        //分配之间缓冲区
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        System.out.println(buffer.isDirect());
    }

    @Test
    public void test1(){
        String str = "abcde";
        //分配一个指定大小的缓冲区
        ByteBuffer buf  = ByteBuffer.allocate(1024);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("-----------------------------------");
        //利用put方法存入数据到缓冲区
        buf.put(str.getBytes());
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("-----------------------------------");
        //切换成读取数据的模式
        buf.flip();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        //读取数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println("-----------------------------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("------------------------------");
        //rewind()方法:可重复读数据
        buf.rewind();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("------------------------------");
        //clear():清空缓冲区,缓冲区的数据依旧存在，处于“被遗忘”状态
        buf.clear();
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

    }
    @Test
    public void test2(){
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(str.getBytes());
        //切换成读模式
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst));
        System.out.println(buf.position());
        //mark标记一下
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst));
        System.out.println(buf.position());
        //恢复到mark的位置
        buf.reset();
        System.out.println(buf.position());
        //判断缓冲区中是否还有剩余的数量
        if (buf.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());
        }
    }

}
