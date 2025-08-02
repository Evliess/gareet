package leetcode;

public class DP_Leet5 {
    public static String longestPalindrome(String s) {
        int max = 1;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] even = expandAt(s, i, i);
            int[] odd = expandAt(s, i, i + 1);
            if (even[1] > max) {
                max = even[1];
                start = even[0];
            }
            if (odd[1] > max) {
                max = odd[1];
                start = odd[0];
            }
        }
        return s.substring(start, start + max);
    }

    public static int[] expandAt(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int len = right - left - 1;
        return new int[]{left + 1, len};
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
//        System.out.println(dp_solution("babad")); //bab
//        System.out.println(dp_solution("cbbd")); //bb
        System.out.println(longestPalindrome("aaaaaaabaaaaaaaa"));
    }
}
