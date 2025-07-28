package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leet128 {

    public int solution(int[] nums) {
        if (nums.length < 2) return nums.length;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : set) {
            //试想如果num-1存在set中，那么这个序列肯定不是从num开始，所以跳过
            if (!set.contains(num - 1)) {
                int curr = num;
                int len = 1;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            int x = num;
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
