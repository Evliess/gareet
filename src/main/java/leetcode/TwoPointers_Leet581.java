package leetcode;

import java.util.Arrays;

public class TwoPointers_Leet581 {
    public static int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        int[] sorted = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(sorted);
        int left = 0;
        int right = nums.length - 1;
        while (nums[left] == sorted[left]) {
            left++;
            if (left == nums.length - 1) return 0;
        }
        while (nums[right] == sorted[right]) {
            right--;
        }
        return right - left + 1;
    }

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 1) return 0;
        int start = 0;
        int end = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        //右边找起点
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) {
                start = i;
            } else {
                //找到小的，更新小的
                min = nums[i];
            }
        }
        //左边找终点
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 4};
        System.out.println(findUnsortedSubarray(nums));
        System.out.println(solution(nums));
    }
}
