package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leet78 {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(nums, ans, new ArrayList<>(), 0);
        return ans;
    }

    public static void backTrack(int[] nums, List<List<Integer>> ans, List<Integer> path, int length) {
        ans.add(new ArrayList<>(path));
        for (int i = length; i <nums.length; i++) {
            path.add(nums[i]);
            backTrack(nums, ans, path, i+1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = subsets(new int[] {1,2,3});
    }
}
