package LeetCode.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/*
4 3 2 2

2 3 4 6 10 14 15 16

4 3 2 5

-1
 */
public class CriclePath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//棋盘大小
        int xc = sc.nextInt();
        int yc = sc.nextInt();
        int r = sc.nextInt();
        ArrayList<Integer> res = new ArrayList<>();

        //四个边界
        int lb = xc - r;//左边界
        int rb = xc + r;//右
        int ub = yc + r;//上
        int db = yc - r;//下

        if (lb < 0 && db < 0 && rb > n && ub > n) {
            System.out.println(-1);
            return;
        }

        //调整
        lb = lb > 0 ? lb : 0;//左边界
        rb = rb < n ? rb : n;//右
        ub = ub < n ? ub : n;//上
        db = db > 0 ? db : 0;//下

        //扫描
        for (int i = db; i < ub; i++) {
            for (int j = lb; j < rb; j++) {
                //计算四个点，以及当前格子的值
                int girdNum = i * n + j + 1;
                boolean d1 = Math.sqrt((j - xc) * (j - xc) + (i - yc) * (i - yc)) - r > 0 ? true : false;
                boolean d2 = Math.sqrt((j + 1 - xc) * (j + 1 - xc) + (i - yc) * (i - yc)) - r > 0 ? true : false;
                boolean d3 = Math.sqrt((j - xc) * (j - xc) + (i + 1 - yc) * (i + 1 - yc)) - r > 0 ? true : false;
                boolean d4 = Math.sqrt((j + 1 - xc) * (j + 1 - xc) + (i + 1 - yc) * (i + 1 - yc)) - r > 0 ? true : false;
                if (d1^d2^d3^d4) {
                    res.add(girdNum);
                }
            }
        }

        for (int i = 0; i < res.size(); i++) {
            if (i != 0 )
                System.out.print(" ");
            System.out.print(res.get(i));
        }

    }
}
