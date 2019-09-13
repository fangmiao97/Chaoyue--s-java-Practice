package network.icq;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {

        //保存客户端处理线程
        Vector<UserThread> vector = new Vector<>();

        //线程池
        ExecutorService es = Executors.newFixedThreadPool(5);

        //创建服务器端的socket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器已启动，等待客户端连接。。。");

        while (true) {
            Socket socket = serverSocket.accept();
            UserThread userThread = new UserThread(socket, vector);
            es.execute(userThread);
        }
    }
}

class UserThread implements Runnable {

    private String name;//客户端用户名称（唯一）
    private Socket socket;

    private Vector<UserThread> vector;//保存服务器上所有处理客户端线程的vector，来通信

    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    private boolean flag = true;//客户端是还在线上

    public UserThread(Socket socket, Vector<UserThread> vector) {
        this.socket = socket;
        this.vector = vector;
        vector.add(this);//将当前新创建的UserThread添加到vector中
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress().getHostAddress() + "已连接");
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());

            while (flag) {
                Message message = (Message)ois.readObject();
                int type = message.getType();

                switch (type) {
                    case MessageType.TYPE_LOGIN:
                        name = message.getFrom();
                        message.setInfo("欢迎你：" + name);
                        oos.writeObject(message);
                        break;

                    case MessageType.TYPE_SEND:
                        String to = message.getTo();
                        UserThread ut;
                        int size = vector.size();
                        for (int i = 0; i < size; i++) {
                            ut = vector.get(i);
                            if(to.equals(ut.name) && ut != this) {
                                ut.oos.writeObject(message);
                                break;
                            }
                        }

                        break;



                }
            }

            ois.close();
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
