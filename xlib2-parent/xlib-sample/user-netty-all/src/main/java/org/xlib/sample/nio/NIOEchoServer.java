package org.xlib.sample.nio;

import org.xlib.sample.ServerInfo;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: dengshengwu
 * @DateTime: 2019/12/15 9:34
 * @description:
 **/
public class NIOEchoServer {
    public void start() throws Exception{

        // 创建固定大小的线程池
        ExecutorService service = Executors.newFixedThreadPool(32);

        // 初始化ServerSocketChannel对象
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(ServerInfo.SERVER_HOST,ServerInfo.SERVER_PORT));


        // 开启选择器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        int keySelect = 0;

        while ((keySelect = selector.select())>0) {
            System.err.println("【NIOEchoServer】获取到连接的数量为：" + keySelect);
            // 获取当前的所有连接信息
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> selectionKeysIterator = selectionKeySet.iterator();

            while (selectionKeysIterator.hasNext()) {
                SelectionKey selectionKey = selectionKeysIterator.next();
                if (selectionKey.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    if (socketChannel != null) {
                        service.submit(new NIOEchoThread(socketChannel));
                    }
                }
                selectionKeysIterator.remove();
            }
        }
        service.shutdown();
        serverSocketChannel.close();
    }

    public static void main(String[] args) throws Exception {
        new NIOEchoServer().start();
    }
}
