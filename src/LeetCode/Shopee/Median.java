package LeetCode.Shopee;

import java.util.*;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/2/15 14:13
 * @Description：求中位数
 */
public class Median {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        while (in.hasNext()) {
            String next = in.next();
            //System.out.println(next.length());
            boolean f = false;
            if (!next.contains(",")) {
                f = true;
            }
            if (f) {

            } else {
                next = next.substring(0, next.length() - 1);
            }
            //System.out.println(next);
            arr.add(Integer.valueOf(next));
            if (f) {
                break;
            }
        }

        //System.out.println("here");
        Collections.sort(arr);
        //System.out.println("size"+arr.size());
        //for (Integer i:arr)
//            System.out.println(i);
        double res = 0;
        int len = arr.size();
        if ((len % 2) == 0) {
            res = arr.get((len / 2) - 1) + arr.get(len / 2);
            res /= 2;
            System.out.println(res);
        } else {
            res = arr.get(arr.size() / 2);
            System.out.println(res);
        }

    }
}
