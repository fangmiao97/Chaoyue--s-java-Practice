package LeetCode.Shopee;

import java.util.Scanner;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/2/15 15:05
 * @Description：商品数
 * product:3m n95 口罩,num:10000;product:84 消毒液,num:100
 */
public class ProductNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            String next = in.next();
            System.out.println(next);
            sb.append(next);
        }
    }
}
