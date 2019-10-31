package LeetCode.huawei;


import java.util.Scanner;

public class BashCovert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        //判断是否有bash部分
        boolean isBash = s.contains("#");
        if(isBash) {
            int base = Integer.parseInt(s.split("#")[0]);
            String bashStr = s.substring(3);
            int d;
            int p = 0;//权值
            int res = 0;
            char c;
            int length = bashStr.length();
            for (int i = 0; i < length; i++) {
                c = bashStr.charAt(i);

                if (Character.isDigit(c)) {
                    d = c;
                } else if (c >= 'a' && c <= 'z') {
                    d = c - 55;
                } else if (c >= 'A' && c <= 'Z') {
                    d = c - 29;//-65 + 36
                } else if (c == '@') {
                    d = 63;
                } else if (c == '_') {
                    d = 64;
                } else
                    d = 0;

                p = length - 1 - i;
                if (d != 0) {
                    res += d * Math.pow(base, p);
                }
            }
            System.out.println(res);
            return;

        } else {
            if (charArray[0] == '0') {
                if (charArray[1] == 'x' || charArray[1] == 'X') {
                    //16进制
                    String hexStr = s.substring(2);
                    char[] hexChars = hexStr.toCharArray();
                    for (char num: hexChars) {
                        if (!Character.isDigit(num) && num < 'a' || num > 'f') {
                            System.out.println("ERROR");
                            return;
                        }
                    }
                    System.out.println(Integer.parseInt(hexStr, 16));
                    return;
                } else {
                    //8进制
                    String octStr = s.substring(1);
                    char[] octChars = octStr.toCharArray();
                    for (char num: octChars) {
                        if (num > '7' || !Character.isDigit(num)) {
                            System.out.println("ERROR");
                            return;
                        }
                    }
                    System.out.println(Integer.parseInt(octStr, 8));
                    return;
                }
            }
            //十进制
            System.out.println(s);
            return;
        }
    }
}
