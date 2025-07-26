package leetcode;

public class DP_Leet53 {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curr = nums[0];
        int max = curr;
        for (int i = 1; i < nums.length; i++) {
            curr += nums[i];
            if (curr < nums[i]) curr = nums[i];
            max = Math.max(max, curr);
        }
        return max;
    }

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int ans = dp[0];
        for (int j : dp) {
            ans = Math.max(ans, j);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution(nums));
    }
}
