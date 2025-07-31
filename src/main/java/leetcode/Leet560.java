package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet560 {

    //最优解
    public static int solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); //初始化index==0 的前缀和，出现次数=1
        int pre = 0;
        int count = 0;
        for (int num : nums) {
            pre = pre + num;
            map.put(pre, map.getOrDefault(pre, 0) + 1);
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
        }
        return count;
    }


    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] prefixSum = calcPrefixSum(nums);
        int ans = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            for (int j = i; j < prefixSum.length; j++) {
                if (prefixSum[j] + nums[j] - prefixSum[i] == k) ans++;
            }
        }
        return ans;
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


    public static int[] calcPrefixSum(int[] nums) {
        int[] prefixSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        return prefixSum;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 1};
        System.out.println(solution(a, 2));
    }
}
