package LeetCode;

import java.util.Scanner;

public class SXH {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    }

    public static boolean isSXH(int num) {
        int temp = num;
        int a = num / 100;
        num %= 100;
        int b = num / 10;
        int c = num % 10;
        if(temp == a * a * a + b * b * b + c * c * c)
            return true;
        return false;
    }
}
