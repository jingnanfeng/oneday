package com.nanfeng.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-07-03 11:05
 */
public class TestOne {
    public static void main(String[] args) throws Exception{
        RandomAccessFile accessFile = new RandomAccessFile("E:\\aaa.txt","rw");
        //建立通道
        FileChannel inChannel = accessFile.getChannel();
        //建立缓冲区,容量为48个type
        ByteBuffer buffer = ByteBuffer.allocate(48);
        //将通道中的字节读到缓冲区
        int bytesRead = inChannel.read(buffer);
        while (bytesRead != -1){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            bytesRead = inChannel.read(buffer);
        }
        accessFile.close();
    }
}
