package com.nanfeng.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-04 23:04
 */
public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.
                open(new InetSocketAddress("127.0.0.1", 9898));

        FileChannel channel = FileChannel.open(Paths.get("D:/test/1.jpg"), StandardOpenOption.READ);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (channel.read(buffer) != -1){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        //接收服务端的反馈
        //while (socketChannel)


    }

}
