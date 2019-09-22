package LeetCode.Tencent;

import java.util.Scanner;

/**
 * 2 //用例数
 * 11 该用例位数
 * 88888888888 用例
 * 3
 * 000
 *
 * YES//通过0或多次删除字符的操作之后，是有效号码
 * NO
 *
 * 有效号码：11位，第一位为8
 */

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int length = in.nextInt();
            in.nextLine();
            String phoneNumber = in.nextLine();
            if (isValid(phoneNumber)) {
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }

    public static boolean isValid(String s) {
        if(s.charAt(0) == '8') {
            return true;
        }
        if (s.length() < 11)
            return false;
        if(s.charAt(0) != '8' && s.length() <= 11) {
            return false;
        }
        int index = s.indexOf('8');
        return isValid(s.substring(index));
    }

}
