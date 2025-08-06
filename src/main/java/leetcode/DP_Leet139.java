package leetcode;

import java.util.Arrays;
import java.util.List;

public class DP_Leet139 {
    //dp[i] 表示字符串 s 的前 i 个字符（即 s[0...i-1]）能否被字典中的单词拆分。
    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) return true;
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true; //代表空字符串可以被拆分 dp[1] 代表 s中第一个字符串可以被拆分,下标从0计算
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                int end = i + word.length();
                if (end <= len && s.substring(i, end).equals(word)) {
                    dp[end] = true;
                    if (end == len) {
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
