package leetcode;

import java.util.HashSet;
import java.util.Set;

public class TwoPointers_Leet3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return -1;
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;

    }
}
