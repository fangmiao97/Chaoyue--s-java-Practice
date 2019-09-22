package LeetCode;



import java.math.BigInteger;
import java.util.Scanner;

/**
 * input:一个正整数n（n<=5000）如：7 7！= 5040
 * output: 一位数答案，表示最后一位不为0的数字 4
 */
public class WeBank1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer base = n;
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= base; i++){
            String temp1 = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp1);
            result = result.multiply(temp2);
        }

        char[] numChars = result.toString().toCharArray();
        for (int i = numChars.length - 1; i >= 0; i--) {
            if(numChars[i] != '0') {
                System.out.println(numChars[i]);
                break;
            }
        }
    }

}
