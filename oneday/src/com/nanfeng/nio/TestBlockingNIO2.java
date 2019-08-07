package com.nanfeng.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-04 23:04
 */
public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.
                open(new InetSocketAddress("127.0.0.1", 9898));
        //切换成非阻塞式
        socketChannel.configureBlocking(false);
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //发送数据到服务端
/*        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString() +"\n" +str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }*/

        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
        //关闭通道
        socketChannel.close();
    }

    @Test
    public void client1() throws IOException {
        //获取通道
        SocketChannel socketChannel = SocketChannel.
                open(new InetSocketAddress("127.0.0.1", 9898));
        //切换成非阻塞式
        socketChannel.configureBlocking(false);
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //发送数据到服务端
/*        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            buf.put((new Date().toString() +"\n" +str).getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }*/

        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.rewind();
        //关闭通道
        socketChannel.close();
    }

    @Test
    public void server() throws IOException{
        //获取通道
        ServerSocketChannel ssChannle = ServerSocketChannel.open();
        //切换成非阻塞模式
        ssChannle.configureBlocking(false);
        //绑定连接
        ssChannle.bind(new InetSocketAddress(9898));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册到选择器上(第二个字段，选择键（监控通道状态）)
        //SelectionKey.OP_ACCEPT 接收
        //SelectionKey.OP_CONNECT 连接
        //SelectionKey.OP_READ 读
        //SelectionKey.OP_WRITE 写
        ssChannle.register(selector, SelectionKey.OP_ACCEPT);
        //轮询式获取选择器上已经准备的时间
        while (selector.select() >0){
            //获取当前选择中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取准备就绪的事件
                SelectionKey sk = iterator.next();
                if (sk.isAcceptable()){
                    //获取客户端连接
                    SocketChannel socketChannel = ssChannle.accept();
                    //切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //将通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //获取当前选择上读就绪状态的通道
                    SocketChannel sChannel = (SocketChannel)sk.channel();
                    //读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.rewind();
                    }
                }
                //取消选择键
                iterator.remove();

            }
        }


    }

}
