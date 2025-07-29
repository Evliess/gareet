package org.example;

//
public class Knapsack {

    public static int solution(int k, int[] weights, int[] vals) {
        int[][] dp = new int[weights.length + 1][k + 1];
        //初始化

        //没有物品时候，价值为0
        for (int i = 0; i < k + 1; i++) {
            dp[0][i] = 0;
        }
        //背包容量为0时，价值为0
        for (int j = 0; j < weights.length + 1; j++) {
            dp[j][0] = 0;
        }

        for (int i = 1; i <= weights.length; i++) {
            for (int j = 1; j <= k; j++) {
                if (j < weights[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i - 1]] + vals[i - 1]);
                }
            }
        }

        int i = 4;
        int n = 8;
        while (i > 0 && n > 0) {
            if (dp[i][n] == dp[i - 1][n]) {
                i--;
            } else {
                System.out.println(i + " 包含");
                i--;
                n = n - weights[i];
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
