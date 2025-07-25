package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers_Leet15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] > 0) break;
                int sum = nums[left] + nums[i] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right - 1] == nums[right]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0};
        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }
}
