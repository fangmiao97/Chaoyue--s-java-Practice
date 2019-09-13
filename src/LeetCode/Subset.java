package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<Integer> res = largestDivisibleSubset(nums);
        System.out.println(res);
    }
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<>();

        //先排序
        Arrays.sort(nums);
        List<List<Integer>> sets = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0 && sets.get(j).size() > subset.size()) {
                    subset = new ArrayList<>(sets.get(j));
                }
            }
            subset.add(nums[i]);
            sets.add(subset);
        }
        int index = 0;
        for(int i = 0; i < sets.size(); i++) {
            if(sets.get(i).size() > sets.get(index).size())
                index = i;
        }
        return sets.get(index);
    }
}
