package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutilServerDemo {
    public static void main(String[] args) throws IOException {

        ExecutorService es = Executors.newFixedThreadPool(3);

        ServerSocket server = new ServerSocket(6666);
        System.out.println("服务器已启动，正在等待连接");
        while (true) {
            Socket s = server.accept();
            System.out.println(s.getInetAddress().getHostAddress());

            //创建线程
            es.execute(new UserThread(s));
        }
    }
}

/**
 * 处理客户端信息
 */
class UserThread implements Runnable {

    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));

            PrintStream ps = new PrintStream(
                    new BufferedOutputStream(s.getOutputStream())
            );

            String info = br.readLine();
            System.out.println(info);
            ps.println("echo" + info);
            ps.flush();
            ps.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
