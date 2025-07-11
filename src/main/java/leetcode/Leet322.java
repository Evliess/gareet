package leetcode;

import java.util.Arrays;

public class Leet322 {

    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        //设置初始值
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) {
                //硬币面额小于当前金额，并且dp[i-coin]有有效的值
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) return -1;
        else return dp[amount];
    }

    public static void main(String[] args) {
        int ans = coinChange(new int[]{2}, 3);
        System.out.println(ans);
    }


}
