package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers_Leet15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int right = nums.length - 1;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //i-1的时候已经计算过了，所以跳过
            int left = i + 1;
            while (left < right) {
                if (nums[i] > 0) break; //三个数中最小的大于0，三数之和肯定大于0
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; //跳重复数
                    while (left < right && nums[right - 1] == nums[right]) right--; //跳重复数
                    left++; //左指针右移
                    right--;//右指针左移
                } else if (sum < 0) left++; //和小于0移动做指针
                else right--; //和大于零移动右指针
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
