package leetcode;

import java.util.Arrays;

public class TwoPointers_Leet287 {

    //功能正常，但是复杂度太高
    public static int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return -1;
    }


    public static int solution1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }


    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 2, 2}));
    }
}
