package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class xunfei1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String des = in.nextLine();
        int n = Integer.parseInt(des.split(";")[0]);
        char[] charArray = des.split(";")[1].toCharArray();
        int length = charArray.length;
        int rNmu = length / n + 1;

        char[][] res = new char[rNmu][n];
        for (char[] ca: res)
            Arrays.fill(ca, ' ');

        int index = 0;
        for (int i = 0; i < rNmu; i++) {
            for (int j = 0; j < n; j++) {
                if(index <= length - 1) {
                    res[i][j] = charArray[index++];
                }
            }
        }

        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < rNmu; j++) {
                ans += res[j][i];
            }
        }

        System.out.println(ans);

    }
}
