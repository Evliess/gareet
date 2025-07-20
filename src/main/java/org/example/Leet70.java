package org.example;

public class Leet70 {
    public int climbStairs(int n) {
        return solution(n);
    }


    public int solution1(int n) {
        if (n < 3) return n;
        int a = 1;
        int b = 2;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = b;
            b = a + b;
            a = temp;
        }
        return b;
    }

    public int solution(int n) {
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


}
