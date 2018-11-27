package com.allen.stone.api.learn.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO java n
 *
 * @Author Allen
 * @Description
 * @Date 2018/10/20 17:19
 **/
public class NIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8888));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            int selected = selector.select();
            if(selected == 0){
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                   ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                   SocketChannel cChannel = channel.accept();
                }

            }
        }
    }


}
