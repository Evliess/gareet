package org.example;

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

    public static void main(String[] args) {
        System.out.println(fib(30));
        System.out.println(fib1(30));
    }
}