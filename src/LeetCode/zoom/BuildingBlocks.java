package LeetCode.zoom;


import java.util.Scanner;

/**
 * 5
 * 2 2
 * 2 4
 * 3 3
 * 2 5
 * 4 5
 *
 * 4
 */

public class BuildingBlocks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] size = new int[n][2];
        int[] areas = new int[n];
        int[] oneOrder = new int[n];
        int[] twoOrder = new int[n];
        for (int i = 0; i < n; i++) {
            int one = in.nextInt();
            int two = in.nextInt();
            size[i][0] = one;
            size[i][1] = two;
            int area = one * two;
            areas[i] = area;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j == twoOrder[i])
                    continue;
                min = Math.min(min, size[j][1]);
            }
            twoOrder[i] = index;
        }

        int[] twoAreas = new int[n];
        for (int i = 0; i < n; i++) {
            twoAreas[i] = areas[twoOrder[i]];
        }

        int[] oneAreas = new int[n];
        for (int i = 0; i < n; i++) {
            oneAreas[i] = areas[oneAreas[i]];
        }

        min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int index = 0;
            for (int j = 0; j < n; j++) {
                if (j == oneOrder[i])
                    continue;
                min = Math.min(min, size[j][0]);
            }
            oneOrder[i] = index;
        }

        int res1 = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (twoAreas[i] > max) {
                res1++;
                max = areas[i];
            }
        }
        int res2 = 0;
        max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (oneAreas[i] > max) {
                res2++;
                max = areas[i];
            }
        }
        System.out.println(Math.max(res1, res2));

    }
}
