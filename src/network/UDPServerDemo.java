package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServerDemo {
    public static void main(String[] args) throws IOException {

        String info = "女神卡卡 A Star is Born";
        byte[] bytes = info.getBytes();

        DatagramPacket dp = new DatagramPacket(
                bytes,
                0,
                bytes.length,
                InetAddress.getByName("127.0.0.1"),
                8000
        );

        DatagramSocket socket = new DatagramSocket(9000);//本程序端口
        socket.send(dp);
        socket.close();
    }
}
