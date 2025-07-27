package leetcode;

import java.util.List;

public class DP_Leet139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(0, 0));
    }
}
