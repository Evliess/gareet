package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Window_Leet3 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if (s == null || s.isEmpty()) return max;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                //abcaecfg
                //   1 3  第二个a进去的时候left改为1，当c进去的时候。left改为3
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {


    }
}
