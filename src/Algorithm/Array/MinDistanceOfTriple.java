package Algorithm.Array;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/1 18:55
 * @Description：已知三个升序整数数组a[l]、b[m]和c[n]，
 * 在三个数组中各找一个元素，使得组成的三元组距离最小。
 * 三元组距离的定义：假设a[i]、b[j]和c[k]是一个三元组，
 * 那么距离为：Distance=max（|a[i]-b[j]|,|a[i]-c[k]|,|b[j]-c[k]|），
 * 设计一个求最小三元组距离的最优算法。
 *
 * 从三个数组的第一个元素开始，首先求出它们的距离minDist，
 * 接着找出这三个数中最小数所在的数组，
 * 只对这个数组的下标往后移一个位置，
 * 接着求三个数组中当前遍历元素的距离，
 * 如果比minDist小，则把当前距离赋值给minDist，
 * 依此类推，直到遍历完其中一个数组为止。
 */
public class MinDistanceOfTriple {

    /**
     * @Description: minDistance
     * @Param:  [a, b, c]
     * @Return: int
     * @Author: FANG MIAO
     * @Date: 2020/1/1 19:02
     * @Time Complexity: O()
     * @Space ComplexityL O()
     */
    public static int minDistance(int[] a, int[] b, int[] c) {
        int aLen = a.length;
        int bLen = b.length;
        int cLen = c.length;
        int curDist = 0;
        int minDist = Integer.MAX_VALUE;

        int aIndex = 0;
        int bIndex=0;
        int cLindex = 0;

        int minIndex = 0;//当前三元组最小元素
        while (true) {
            curDist = min(Math.abs(a[aIndex] - b[bIndex]),
                    Math.abs(a[aIndex] - c[cLindex]),
                    Math.abs(b[bIndex] - c[cLindex]));
            minDist = Math.min(curDist, minDist);
            minIndex = min(a[aIndex], b[bIndex], c[cLindex]);

            if (minIndex == a[aIndex]) {
                aIndex++;
                if (aIndex >= aLen) {
                    break;//当某数组遍历完时，说明所有情况都考虑了
                }
            } else if (minIndex == b[bIndex]) {
                bIndex++;
                if (bIndex >= bLen) {
                    break;
                }
            } else if (minIndex == c[cLindex]) {
                cLindex++;
                if (cLindex >= cLen) {
                    break;
                }
            }
        }

        return minDist;
    }

    //三元组最大
    private static int max(int a, int b, int c) {
        int max = Math.max(a, b);
        return Math.max(max, c);
    }

    private static int min(int a, int b, int c) {
        int min = Math.min(a, b);
        return Math.min(min, c);
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 7, 15};
        int[] b = {10, 12, 14, 16, 17};
        int[] c = {20, 21, 23, 24, 37, 30};

        System.out.println(minDistance(a, b, c));
    }
}
