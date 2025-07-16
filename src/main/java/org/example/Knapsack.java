package org.example;

//
public class Knapsack {

    public static int solution(int k, int[] weights, int[] vals) {
        int[][] dp = new int[weights.length + 1][k + 1];
        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j >= weights[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + vals[i - 1]);
                } else {
                    //当前物品的重量超过背包的剩余容量
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weights.length][k];
    }

    public static void main(String[] args) {
        int k = 8;
        int[] vals = new int[]{1, 2, 5, 6};
        int[] weights = new int[]{2, 3, 4, 5};
        System.out.println(solution(k, weights, vals));

    }
}
