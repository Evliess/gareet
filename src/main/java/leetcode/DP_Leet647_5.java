package leetcode;

public class DP_Leet647_5 {

    //中心扩展法
    public static int solution(String s) {
        if (s == null || s.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

    public static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }


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

    public static void main(String[] args) {
        System.out.println(solution("aaa"));
    }
}
