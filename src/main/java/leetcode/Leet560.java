package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet560 {
    public static int subarraySum(int[] nums, int k) {
        calcPrefixSum(nums);
        int count = 0;
        int a;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) a = 0;
            else a = nums[i - 1];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] - a == k) {
                    count++;
                    System.out.println(i + " : " + j);
                }
            }
        }
        return count;
    }

    public static int solution1(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            //每一个元素计算前缀和
            for (int end = 0; end <= start; end++) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //初始化index==0 的前缀和，出现次数=1
        int pre = 0;
        int count = 0;
        for (int num : nums) {
            pre = pre + num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }


    public static void calcPrefixSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1, 2, 3};
        System.out.println(solution1(a, 3));
    }
}
