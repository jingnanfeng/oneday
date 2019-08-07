package com.nanfeng.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author liutao
 * @Title
 * @Description
 * @date 2019-08-06 20:25
 */
public class TestPipe {

    @Test
    public void test1() throws IOException{
        //获取管道
        Pipe pipe = Pipe.open();
        //将缓冲区的数据写入通道
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向通道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();
  }

}
