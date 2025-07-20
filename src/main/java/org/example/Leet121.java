package org.example;

public class Leet121 {

    public int maxProfit(int[] prices) {
//        return solution1(prices);
        return solution2(prices);
    }

    public int solution1(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    ans = Math.max(ans, prices[j] - prices[i]);
                }
            }
        }
        return ans;
    }

    public int solution2(int[] prices) {
        int ans = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            ans = Math.max(ans, price - minPrice);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};

    }
}
