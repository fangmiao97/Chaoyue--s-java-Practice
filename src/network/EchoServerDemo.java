package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class EchoServerDemo {

    public static void main(String[] args) {
        try {
            //端口号1024 - 65535
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("等待客户端连接");
            //等待客户端连接，等在这，阻塞。如果有客户端连接，就会返回socket对象
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功" + socket.getInetAddress().getHostAddress());
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            //通过输入流读取网络数据，如果没有数据，就会阻塞
            String info = br.readLine();
            System.out.println(info);

            //获取输出流，向客户返回消息
            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(socket.getOutputStream())
            );

            ps.println("echo:" + info);
            ps.flush();

            ps.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
