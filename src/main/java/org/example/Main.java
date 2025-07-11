package org.example;

import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int fib(int n) {
        if (n < 2) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fib1(int n) {
        if (n < 2) return n;
        int pre0 = 0, pre1 = 1;
        for (int i = 2; i <= n; i++) {
            pre1 = pre0 + pre1;
            pre0 = pre1 - pre0;

        }
        return pre1;
    }

    public static int fib2(int n, int[] memo) {
        if (n < 2) return n;
        memo[0] = 0;
        memo[1] = 1;
        if (memo[n] > 0) return memo[n];
        memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        return memo[n];

    }

    public static void main(String[] args) {

        String id = "oI8Jj7Ok25G78_aM8OXFuqIAeNV8";
        System.out.println(id.length());
    }
}