package LeetCode;

import java.util.Scanner;

public class Robot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dir = in.nextLine();
        char[] dirctions = dir.toCharArray();

        int[] res = new int[dirctions.length];

        for(int i = 0; i < dirctions.length; i++) {
            int even = dirctions.length * 2;
            char d = dirctions[i];
            if (d == 'R') {
                if (i + 1 < dirctions.length && dirctions[i + 1] == 'L') {
                    res[i]++;
                }else {
                    int index = i;
                    while (index < dirctions.length && dirctions[index] == 'R') {
                        index++;
                        even--;
                    }
                    if(even % 2 == 1) {
                        res[index - 1]++;
                    }else
                        res[index]++;
                }
            }else if(d == 'L') {
                if (i - 1 >= 0 && dirctions[i - 1] == 'R') {
                    res[i]++;
                }else {
                    int index = i;
                    while (index >= 0&& dirctions[index] == 'L') {
                        index++;
                        even--;
                    }
                    if(even % 2 == 1) {
                        res[index + 1]++;
                    }else
                        res[index]++;
                }
            }


        }

        for (int i = 0;i < res.length - 1; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
        System.out.print(res[res.length - 1]);
        System.out.println();
    }
}
