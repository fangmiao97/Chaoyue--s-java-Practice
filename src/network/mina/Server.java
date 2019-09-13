package network.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {

        //创建一个非阻塞的Server端Socket  NIO
        SocketAcceptor acceptor = new NioSocketAcceptor();
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设计一个过滤器，一行行读取(/r/n)
        chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));
        //设计服务端的消息处理器
        acceptor.setHandler(new MinaServerHandler());

        int port = 9999;
        acceptor.bind(new InetSocketAddress(port));
        System.out.println("mina服务器启动，监听端口：" + port);
    }
}
