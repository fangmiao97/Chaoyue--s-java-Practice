package network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MutilClientDemo {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //创建一个socket对象，指定要连接的服务器,下面这一行结束，EchoServerDemo的16行就不会阻塞了
        Socket socket = new Socket("localhost", 6666);

        PrintStream ps = new PrintStream(
                new BufferedOutputStream(socket.getOutputStream())
        );

        BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );

        //向socket中写
        System.out.println("请输入发往服务器的消息：");
        String s = sc.nextLine();
        ps.println(s);
        ps.flush();

        String info = br.readLine();
        System.out.println(info);

        ps.close();
        br.close();
    }
}
