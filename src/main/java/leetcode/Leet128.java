package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet128 {

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            int x = num;
            int max;
            while (set.contains(x - 1)) {
                x--;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
