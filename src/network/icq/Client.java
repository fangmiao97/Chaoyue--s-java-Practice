package network.icq;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Executable;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Socket socket = new Socket("localhost", 6666);
        System.out.println("服务器连接成功");

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());//客户端oos要在ois之前
        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


        //向服务器发送登录信息
        System.out.println("请输入用户名称：");
        String name = sc.nextLine();
        Message message = new Message(name, null, MessageType.TYPE_LOGIN, null);
        oos.writeObject(message);
        message = (Message) ois.readObject();
        System.out.println(message.getInfo());

        //单开一个自动读取信息的线程
        executorService.execute(new ReadInfoThread(ois));

        //主线程实现发送消息
        boolean flag = true;
        while (true) {
            message = new Message();
            System.out.println("To:");
            message.setTo(sc.nextLine());
            message.setType(MessageType.TYPE_SEND);
            message.setFrom(name);
            System.out.println("info:");
            message.setInfo(sc.nextLine());
            oos.writeObject(message);

        }
    }
}

//读取信息
class ReadInfoThread implements Runnable {

    private ObjectInputStream in;
    private boolean flag = true;

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ReadInfoThread(ObjectInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {

        while (flag) {
            try {
                Message message = (Message) in.readObject();
                System.out.println("[" + message.getFrom() + "]:" + message.getInfo());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if(in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
