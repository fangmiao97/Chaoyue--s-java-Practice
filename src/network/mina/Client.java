package network.mina;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.serialization.ObjectSerializationCodecFactory;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        //创建连接
        NioSocketConnector connector = new NioSocketConnector();
        DefaultIoFilterChainBuilder chain = connector.getFilterChain();
//        chain.addLast("myChain", new ProtocolCodecFilter(new TextLineCodecFactory()));

        //设定过滤器为对象为单位读取数据
        chain.addLast("objectFilter", new ProtocolCodecFilter(new ObjectSerializationCodecFactory()));
        connector.setHandler(new MinaClientHandler());
        connector.setConnectTimeoutMillis(10000);

        //连接服务器
        ConnectFuture connect = connector.connect(new InetSocketAddress("localhost", 9999));
        connect.awaitUninterruptibly();//等待连接成功
        Scanner in = new Scanner(System.in);

        while (true) {
//            System.out.println("请输入信息：");
//            String info = in.nextLine();
//            connect.getSession().write(info);

            Message msg = new Message();
            System.out.println("from:");
            msg.setFrom(in.nextLine());
            System.out.println("to:");
            msg.setTo(in.nextLine());
            System.out.println("type:");
            msg.setType(in.nextLine());
            System.out.println("info:");
            msg.setInfo(in.nextLine());

            connect.getSession().write(msg);
        }

        //等待服务器连接关闭
//        connect.getSession().getCloseFuture().awaitUninterruptibly();
//        connector.dispose();

    }
}
