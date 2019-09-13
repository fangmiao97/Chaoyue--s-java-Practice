package LeetCode;

import java.util.Scanner;

public class CycleIntersection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String coos = in.nextLine();
        int[] red = new int[3];
        int[] blue = new int[3];
        int[] green = new int[3];
        String[] cooArr = coos.split(";");

        for (int i = 0; i < 3; i++) {
            String[] cs = cooArr[i].split(",");
            for (int j = 0; j < 3; j++) {
                if(i == 0) {
                    red[j] = Integer.parseInt(cs[j]);
                }else if(i == 1) {
                    blue[j] = Integer.parseInt(cs[j]);
                }else {
                    green[j] = Integer.parseInt(cs[j]);
                }
            }
        }

        String res = "";
        res += judge(red, blue, 1);
        res += ",";
        res += judge(red, green, 2);
        res += ",";
        res += judge(blue, green, 3);

        System.out.println(res);



    }

    public static String judge(int[] A, int[] B, int index) {

        boolean flag = false;
        String res = "";
        double distance = Math.sqrt(Math.pow(A[0] - B[0], 2) + Math.pow(A[1] - B[1], 2));
        if(distance <= A[2] + B[2]) {
            flag =true;
        }

        if(flag) {
            switch (index) {
                case 1:
                    res = "红蓝圈相交";
                    break;
                case 2:
                    res = "红绿圈相交";
                    break;
                case 3:
                    res =  "蓝绿圈相交";
                    break;
            }
        }
        else {
            switch (index) {
                case 1:
                    res = "红蓝圈不相交";
                    break;
                case 2:
                    res = "红绿圈不相交";
                    break;
                case 3:
                    res = "蓝绿圈不相交";
                    break;
            }
        }

        return res;
    }
}
