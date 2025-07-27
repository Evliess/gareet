package leetcode;

public class DP_Leet647_5 {

    public int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int ans = 0;
        //处理single character
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            ans++;
        }
        //处理double character
        for (int i = 0; i < length - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                ans++;
            }
        }
        //处理长度大于等于3个的字符串
        for (int l = 3; l <= length; l++) {
            for (int i = 0; i <= length - l; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
