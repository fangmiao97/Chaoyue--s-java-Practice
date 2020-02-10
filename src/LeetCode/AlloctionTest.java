package LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class  AlloctionTest {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] num = new int[n];
            String[] s = new String[n - 1];
            for(int i = 0; i < 2 * n - 1; i++) {
                if(i % 2 == 0){
                    num[i / 2] = sc.nextInt();
                }else {
                    s[(i - 1) / 2] = sc.next();
                }

            }

            int[] res = new int[n];

    //        int index = 0;//符号数组索引
            //先考虑乘
            for(int i = 0; i < s.length; i++) {
                if(s[i] == "*") {
                    int end = i;//连续*的结尾
                    while(i < s.length && s[i] == "*") {
                        end = i;
                        i++;
                    }
                    //对应的数字
                    int[] nums = getNum(num, i, end);
                    //Arrays.sort(nums);//排序
//                    for(int j = 0; j < nums.length; i++) {
//                        num[i + j] = nums[j];
//                    }
                    changeArray(res, nums, i, end);
                    i = end + 1;
                }
            }

            for (int i = 0; i < s.length; i++) {
                if(s[i] == "+") {
                    int end = i;
                    while(i < s.length && s[i] == "*" && s[i + 1] != "*") {
                        end = i;
                        i++;
                    }
                    //对应的数字
                    int[] nums = getNum(num, i, end);
                    //Arrays.sort(nums);//排序
//                    for(int j = 0; j < nums.length; i++) {
//                        num[i + j] = nums[j];
//                    }
                    changeArray(res, nums, i, end);
                    i = end + 1;
                }
            }

            for(int i = 0; i < 2 * n - 1; i++) {
                if(i % 2 == 0){
                    System.out.println(num[i / 2]);
                }else {
                    System.out.println(s[(i - 1) / 2]);
                }

            }
    }

    public static void changeArray(int[] num, int[] nums, int start, int end) {
        for(int i = 0; i < nums.length; i++) {
            num[start + i] = nums[i];
        }
    }

    public static int[] getNum(int[] num, int start, int end) {
        int[] res = new int[end - start + 2];

        for (int i = 0; i < res.length; i++) {
            res[i] = num[start + i];
        }
        Arrays.sort(res);
        return res;
    }

}
