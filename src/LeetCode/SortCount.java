package LeetCode;


import java.util.ArrayList;
import java.util.List;

public class SortCount {

    public static List<ArrayList<Integer>> plist = new ArrayList<>();
    public static int res = 0;

    public static int numPermsDISequence(ArrayList<Integer> form) {
        int n = form.size(), mod = (int)1e9 + 7;
        int[][] dp = new int[n + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 1;
        for (int i = 0; i < n; i++)
            if (form.get(i) == 0)
                for (int j = 0, cur = 0; j < n - i; j++)
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % mod;
            else
                for (int j = n - i - 1, cur = 0; j >= 0; j--)
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % mod;
        return dp[n][0];
    }

    public static void permutation(int[] num, ArrayList<Integer> now, boolean[] seen,
                                   ArrayList<Integer> form, int index) {
        if(now.size() > num.length)
            return;
        if(now.size() == num.length)
            res++;
            //plist.add(new ArrayList<>(now));
        for(int i = 0; i < num.length; i++) {
            if(!seen[i]) {
                if(index == 0) {
                    seen[i] = true;
                    index++;
                    now.add(num[i]);
                    permutation(num, now, seen, form, index);
                    now.remove(now.size() - 1);
                    index--;
                    seen[i] = false;
                    continue;
                }

                int formNum = form.get(index - 1);
                int preNum = now.get(index - 1);
                if(formNum == 0) {
                    if(num[i] > preNum) {
                        seen[i] = true;
                        index++;
                        now.add(num[i]);
                        permutation(num, now, seen, form, index);
                        now.remove(now.size() - 1);
                        index--;
                        seen[i] = false;
                    }
                }else if(formNum == 1) {
                    if(num[i] < preNum) {
                        seen[i] = true;
                        index++;
                        now.add(num[i]);
                        permutation(num, now, seen, form, index);
                        now.remove(now.size() - 1);
                        index--;
                        seen[i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }

        boolean[] seen = new boolean[n];

        ArrayList<Integer> form = new ArrayList<>();
        form.add(1);
        form.add(1);
        form.add(0);

        permutation(num, new ArrayList<>(), seen, form, 0);
        System.out.println(res);

        System.out.println(numPermsDISequence(form));

//        for(ArrayList arrayList: plist) {
//            for (Object i:arrayList)
//                System.out.print(i);
//            System.out.println();
//        }

//        for (ArrayList arrayList: plist) {
//            judge(arrayList, form);
//        }
//        System.out.println(res);
    }

    public static void judge(ArrayList<Integer> list, ArrayList<Integer> form) {
        int n = list.size();
        boolean flag = true;
        for(int i = 0; i < n - 1; i++) {
            int f = form.get(i);
            int num = list.get(i);
            int nextNum = list.get(i + 1);
            if(f == 0) {
                if (num < nextNum)
                    continue;
                else {
                    flag = false;
                    break;
                }
            }else if(f == 1) {
                if(num > nextNum)
                    continue;
                else {
                    flag = false;
                    break;
                }
            }
        }
        if(flag)
            res++;
    }
}
