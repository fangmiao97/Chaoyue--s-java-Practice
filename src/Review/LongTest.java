package Review;

import java.math.BigInteger;

public class LongTest {
    public static void main(String[] args) {
        long v = Long.MAX_VALUE + 1000L;
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MIN_VALUE * -1);//溢出，不正确
        System.out.println(v);//溢出
        System.out.println(longToUnsigned(v));
        System.out.println(longToUnsigned(Long.MAX_VALUE - 1000L));

        System.out.println(Math.multiplyExact(Long.MIN_VALUE, -1));

    }

    public static String longToUnsigned(long signed) {
        if(signed < 0L) {
            BigInteger unsigned = BigInteger.valueOf(signed & Long.MAX_VALUE);
            return unsigned.setBit(63).toString();
        }
        return Long.toString(signed);
    }
}
