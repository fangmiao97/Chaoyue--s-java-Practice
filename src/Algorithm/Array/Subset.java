package Algorithm.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ：FANG MIAO
 * @Date ：Created on 2020/1/2 12:26
 * @Description：子集
 */
public class Subset {


    public static void FindSubSet(List<List<Integer>> res, List<Integer> temp,
                                  int[] arr, int start) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            FindSubSet(res, temp, arr, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void showRes(List<List<Integer>> res) {
        for (List<Integer> l: res
             ) {
            for (Integer integer : l
            ) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        List<List<Integer>> res = new ArrayList<>();
        FindSubSet(res, new ArrayList<>(), arr, 0);
        showRes(res);
    }
}
