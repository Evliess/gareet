package leetcode;

public class DP_Leet5 {
    public static String longestPalindrome(String s) {
        return dp_solution(s);
    }

    public static String dp_solution(String s) {
        if (s == null)
            return null;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            start = i;
        }
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxlen = 2;
            }
        }
        for (int L = 3; L <= len; L++) {
            for (int i = 0; i < len - L; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxlen) {
                        maxlen = j - i + 1;
                        start = i;
                    }
                }

            }
        }
        return s.substring(start, start + maxlen);

    }


    public static void main(String[] args) {
        System.out.println(dp_solution("babad")); //bab
        System.out.println(dp_solution("cbbd")); //bb
    }
}
