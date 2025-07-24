package leetcode;

public class Leet494 {

    public static int findTargetSumWays(int[] nums, int target) {
        return backTrack(nums, target, 0);
    }

    public static int backTrack(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) return 1;
            else return 0;
        }
        int add = backTrack(nums, target - nums[index], index + 1);
        int subtract = backTrack(nums, target + nums[index], index + 1);
        return add + subtract;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int ans = findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}
