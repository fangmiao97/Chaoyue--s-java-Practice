package LeetCode.huawei;

import java.util.Arrays;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/6 11:35
 * @Description：一面代码int转String，看JDK源码
 */
public class ipuls {

    public static String intToString(int i) {

        if (i == 0) {
            return new String("0");
        }

        boolean minus = false;
        if (i < 0) {
            i = -i;
            minus = true;
        }

        char[] resArr = new char[20];
        Arrays.fill(resArr, '0');
        //i=1203450
        int temp = 0;
        int index = 0;
        while (i > 0) {
            temp = i % 10;
            resArr[index] = (char) (temp + '0');
            index++;
            i /= 10;
        }

        //得长度
        int length = 0;
        for (int j = 0; j < resArr.length; j++) {
            if (resArr[resArr.length - 1 - j] == '0') {
                length++;
                continue;
            } else {
                length = 20 - length;
                break;
            }
        }

        char[] resCharArr = new char[length];
        int j = 0;
        if (minus) {
            j = 1;
            resCharArr = new char[length + 1];
            resCharArr[0] = '-';
        }
        for (; j < length; j++) {
            if (minus) {
                resCharArr[j] = resArr[length - j];
                if (j == length - 1) {
                    resCharArr[j + 1] = resArr[0];
                }
            } else {
                resCharArr[j] = resArr[length - 1 - j];
            }

        }

        return new String(resCharArr);
    }

    public static void main(String[] args) {
        int i = -123;
        System.out.println(intToString(i));
        System.out.println(Integer.MAX_VALUE);
    }
}
