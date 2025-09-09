package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Window_Leet438 {

    public static List<Integer> solution(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (char ch : p.toCharArray()) {
            cntP[ch - 'a']++;
        }
        int lenP = p.length();
        for (int i = 0; i < lenP; i++) {
            cntS[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntP, cntS)) ans.add(0);

        for (int i = lenP; i < s.length(); i++) {
            cntS[s.charAt(i - lenP) - 'a']--;
            cntS[s.charAt(i) - 'a']++;
            if (Arrays.equals(cntP, cntS)) ans.add(i - lenP + 1);
        }
        return ans;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null) return ans;
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (sort(p).equals(sort(sub))) ans.add(i);
        }
        return ans;
    }

    public static String sort(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> ans = solution(s, p);
        System.out.println(ans);
    }
}
