package LeetCode;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Alice现在有一个数x，在范围[0,2n)内。你需要询问Alice一些问题。每次询问有一个数t，Alice会回答你 t&x 是否等于t。你不能根据已有的回答改变接下来的询问（即询问需要提前想好）。你需要最少询问多少次来保证你能确定x的值。输出答案mod106+3
 *
 * &的意思是位与运算
 *
 * 当且仅当两种方案中有一个询问不同，我们就认为两种方法是不同的。例如询问[1,2]和[1,3]是不同的，[1,2][2,1]也是不同的（尽管他们得到了相同的结果）
 *
 * 一个正整数n ( n≤10^9 )
 * 一个数，答案mod106+3
 *
 * imput:3
 * output:6
 * 询问的t为1,2,4三个数，有6种排列方式（[1,2,4][1,4,2][2,1,4][2,4,1][4,1,2][4,2,1]）
 */
public class WeBank2 {

    public static final double LOG_2 = Math.log(2.0);
    private static final int MAX_DIGITS_2 = 977; // ~ MAX_DIGITS_10 * LN(10)/LN(2)

    public static BigInteger MOD = new BigInteger("10000003");
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger two = new BigInteger("2");
        BigInteger p = two.pow(n);
        int checkCount = (int) logBigInteger(p) + 1;
//        System.out.println(checkCount);

        System.out.println(permutation(checkCount).remainder(MOD));

    }

    public static double logBigInteger(BigInteger val) {
        if (val.signum() < 1)
            return val.signum() < 0 ? Double.NaN : Double.NEGATIVE_INFINITY;
        int blex = val.bitLength() - MAX_DIGITS_2; // any value in 60..1023 works here
        if (blex > 0)
            val = val.shiftRight(blex);
        double res = Math.log(val.doubleValue());
        return blex > 0 ? res + blex * LOG_2 : res;
    }

    public static BigInteger permutation(int n) {
        Integer base = n;
        BigInteger result = new BigInteger("1");
        for(int i = 1; i <= base; i++){
            String temp1 = Integer.toString(i);
            BigInteger temp2 = new  BigInteger(temp1);
            result = result.multiply(temp2);
        }
        return result;
    }
}
