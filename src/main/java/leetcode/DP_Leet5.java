package leetcode;

public class DP_Leet5 {
    public static String longestPalindrome(String s) {
        return solution(s);
    }


    public static String dp_solution(String s) {
        if (s == null || s.isEmpty()) return s;
        int n = s.length();
        boolean[][] flag = new boolean[n][n];
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < n; i++) flag[i][i] = true;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && flag[i + 1][j - 1]) {
                    flag[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
        return s.substring(start, maxLen);
    }

    public static String solution(String s) {
        if (s == null || s.isEmpty()) return s;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > r - l - 1) {
                l = i - (len - 1) / 2;
                r = i + len / 2;
            }
        }
        return s.substring(l, r + 1);
    }

    public static int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        System.out.println(dp_solution("aabbaa"));
    }
}
