package leetcode;

import java.util.Arrays;

public class DP_Leet416 {
    //类似0-1背包问题
    //dp使用一维数组，反向填充
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum 如果是奇数，那么一定不可分
        if ((sum & 1) == 1) return false;
        int target = sum >> 1;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i > num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    //DP使用二位数组正向填充
    //[1,2,3,5] target = 5;
    public static boolean solution(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum 如果是奇数，那么一定不可分
        if ((sum & 1) == 1) return false;
        int target = sum >> 1;
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            int num = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                if (num > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
                }
            }
        }
        return dp[len][target];
    }


    //这种算法也不对
    //这种统计的是连续的子数组，会漏掉不连续的情况
    //并且返回的结果也有错：反例  [1, 9, 5, 5]
    public static boolean force(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum 如果是奇数，那么一定不可分
        if ((sum & 1) == 1) return false;
        sum = sum >> 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int current = 0;
            for (int j = i; j < nums.length; j++) {
                current += nums[j];
                if (current == sum) return true;
            }
        }
        return false;
    }


    //这种方法并不是总有用
    //反例：[1,2,3,4]
    public static boolean greddy(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum 如果是奇数，那么一定不可分
        if ((sum & 1) == 1) return false;
        sum = sum >> 1;
        Arrays.sort(nums);
        int tmp = 0;
        for (int num : nums) {
            if (tmp < sum) {
                tmp += num;
                if (tmp == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4}; //这是一个反例，贪心不行，需要DP 0/1背包问题
        System.out.println(solution(nums));
    }
}
