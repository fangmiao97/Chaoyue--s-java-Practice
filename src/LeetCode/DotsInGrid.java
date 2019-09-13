package LeetCode;

import java.util.*;

public class DotsInGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeMap<Integer, Integer> table = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );

        for(int i = 0; i < n; i++) {
            int k = sc.nextInt();
            int v = sc.nextInt();
            table.put(k, v);
        }

        List<Integer> ans = new ArrayList<>();

        Map.Entry f = table.pollFirstEntry();
        int maxnum = Integer.MIN_VALUE;
        while (f != null) {
            int k = (int) f.getKey();
            int v = (int) f.getValue();
            if(v > maxnum) {
                ans.add(k);
                ans.add(v);
                maxnum = v;
            }
            f = table.pollFirstEntry();
        }

        int s = ans.size() / 2;
        for(int i = s - 1; i >= 0; i--) {
            System.out.println(ans.get(i * 2) + " " +ans.get(i * 2 + 1));
        }

    }
}
