package leetcode;

public class DP_Leet72 {

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                /**
                 * dp[i][j] 表示的是 word1 的前 i 个字符（即 word1[0..i-1]）和 word2 的前 j 个字符（即 word2[0..j-1]）的编辑距离。
                 * 所以当 i=1 时，表示 word1 的第 1 个字符（word1.charAt(0)），j=1 时表示 word2 的第 1 个字符（word2.charAt(0)）。
                 */
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
