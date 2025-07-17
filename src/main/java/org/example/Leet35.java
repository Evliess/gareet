package org.example;

public class Leet35 {

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle = (left + right) >> 1;
        while (left < right) {
            if (nums[middle] <= target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
            middle = (left + right) >> 1;
        }
        return nums[left] < target ? left + 1 : left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int ans = searchInsert(nums, 7);
        System.out.println(ans);
    }


}
