package leetcode;

import java.util.Arrays;
import java.util.List;

public class DP_Leet139 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                int end = i + word.length();
                if (end <= len && s.substring(i, i + word.length()).equals(word)) {
                    dp[i + word.length()] = true;
                    if (i + word.length() == len) {
                        return true;
                    }
                }
            }
        }
        return dp[len];
    }


    public static void main(String[] args) {
        String s = "applepenapple";
        boolean ans = wordBreak(s, Arrays.asList("apple", "pen"));
        System.out.println(ans);

    }
}
