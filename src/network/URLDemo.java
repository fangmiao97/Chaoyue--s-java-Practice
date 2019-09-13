package network;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://cy-pic.kuaizhan.com/g3/90/25/c1e3-2c33-4109-93c7-e0db6736839859");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("D:\\MyProject\\javaPractice\\src\\network\\download.jpg"));
        byte[] bytes = new byte[1024];
        int len = -1;
        while ((len = in.read(bytes)) != -1) {
            out.write(bytes, 0, len);
            out.flush();
        }
        in.close();
        out.close();
        System.out.println("download done!");
    }
}
