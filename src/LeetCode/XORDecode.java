package LeetCode;

import java.util.Scanner;

public class XORDecode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] ans = new int[n];

        int k = sc.nextInt();

        int code_length = n + k - 1;
        int[] code = new int[code_length];

        String sk = sc.nextLine();

        String code_string = sc.nextLine();
        //System.out.println(code_string);
        for (int i = 0; i < code_length; i++) {
            code[i] = Integer.parseInt(code_string.substring(i, i + 1));
        }

        for (int i = 0; i < k; i++) {
            ans[i] = i == 0 ? code[i] ^ 0 : code[i] ^ code[i - 1];
        }

        for (int i = 0; i < n - k; i++) {
            int temp = code[k - 1 + i] ^ ans[i];
            ans[k + i] = code[k + i] ^ temp;
        }

        for (int num : ans) {
            System.out.print(num);
        }
    }
}
