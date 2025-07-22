package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leet438 {

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
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> ans = findAnagrams(s, p);
        System.out.println(ans);
    }
}
