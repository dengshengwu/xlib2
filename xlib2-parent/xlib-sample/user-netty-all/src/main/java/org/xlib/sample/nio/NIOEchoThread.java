package org.xlib.sample.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/12/15 9:17
 * @description:
 **/
public class NIOEchoThread implements Runnable {
    private SocketChannel socketChannel;

    private boolean flag = true ;


    public NIOEchoThread(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }



    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        try {
            while (this.flag) {
                buffer.clear();

                // 读取socketChannel数据写入缓冲区
                int readCount = this.socketChannel.read(buffer);

                String readMessage = new String(buffer.array(),0,readCount).trim();

                System.err.println("【服务器接收到的消息】" + readMessage);

                String writeMessage = "【ECHO服务器回应消息】" + readMessage;


                if ("exit".equalsIgnoreCase(readMessage)) {
                    writeMessage = "【ECHO服务器回应消息】拜拜，下次再见！";
                }

                // 清空缓冲区
                buffer.clear();
                buffer.put(writeMessage.getBytes());

                // 重置缓冲区
                buffer.flip();

                // 读取缓冲区buffer的数据数据到socketChannel
                this.socketChannel.write(buffer);
            }
            this.socketChannel.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
