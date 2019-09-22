package LeetCode.zoom;

import java.util.Scanner;

/**
 * B000C00
 * 3  //删掉3个连续的0
 *
 * BC00
 */
public class DeleteZeroInStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = in.nextInt();

        char[] charArray = s.toCharArray();
        int[] zeroNum = new int[charArray.length];

        for (int i = 0; i < zeroNum.length; i++) {
            if (i == 0 && charArray[0] == '0') {
                zeroNum[0] = 1;
                continue;
            }
            if (charArray[i] == '0') {
                zeroNum[i] = zeroNum[i - 1] + 1;
            }
        }

        boolean[] deleteArr = new boolean[charArray.length];
        for (int i = 0; i < zeroNum.length; i++) {
            if (zeroNum[i] == n && (i == zeroNum.length - 1 || zeroNum[i + 1] == 0)) {
                for (int j = 0; j < n; j++) {
                    deleteArr[i - j] = true;
                }
            }
        }

        String res = new String();
        for (int i = 0; i < deleteArr.length; i++) {
            if (!deleteArr[i]) {
                res += charArray[i];
            }
        }
        System.out.println(res);
    }
}
