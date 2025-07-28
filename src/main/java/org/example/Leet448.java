package org.example;

import java.util.ArrayList;
import java.util.List;

public class Leet448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) {
            if (!flag[n]) flag[n] = true;
        }
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) ans.add(i);
        }
        return ans;
    }

    public static List<Integer> solution(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) {
            n = Math.abs(n);
            if (nums[n - 1] > 0) nums[n - 1] = -nums[n - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2}));
    }


}
