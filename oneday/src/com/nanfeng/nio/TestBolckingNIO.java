package com.nanfeng.nio;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-04 22:46
 */

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * s使用NIO完成网络通信的三个核心
 * 通道：
 *  Channel接口
 *      SelecttableChannel
 *          SocketChannel
 *          ServerSocketChannel
 *          DataparamChannel
 *
 *          Pipe.SinkChannel
 *          Pipe.SourceChannel
 * 缓冲区（Buffer）负责数据的存储
 * 选择器（Selector） 是SelectableChannel的多路复用器，用于监控SelecttableChannel的状况
 *
 */

public class TestBolckingNIO {

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("D:/test/1.jpg"), StandardOpenOption.READ);
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取本地文件，发送到服务器
        while (inChannel.read(buf) != -1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //关闭通道
        inChannel.close();
        sChannel.close();
    }

    @Test
    public void server() throws IOException{
        //获取通道
        ServerSocketChannel socketChannel = ServerSocketChannel.open();

        FileChannel channel = FileChannel.open(Paths.get("D:/test/11.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //绑定连接
        socketChannel.bind(new InetSocketAddress(9898));
        //获取客户端连接的通道
        SocketChannel socketChannel1 = socketChannel.accept();

        //分配指定大小的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //接收客户端的数据，并保存到本地
        while (socketChannel1.read(buffer) != -1){
            buffer.flip();
            channel.write(buffer);
            buffer.clear();
        }

        socketChannel.close();
        socketChannel1.close();
        channel.close();
    }

}
