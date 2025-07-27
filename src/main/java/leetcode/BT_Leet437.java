package leetcode;

import java.util.HashMap;
import java.util.Map;

public class BT_Leet437 {

    public int solution(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Map<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return backtrack(root, prefixSum, 0, targetSum);
    }

    public int backtrack(TreeNode root, Map<Long, Integer> prefixSum, long currentSum, int target) {
        if (root == null) return 0;
        long val = root.val;
        currentSum += val;
        int ans = prefixSum.getOrDefault(currentSum - target, 0);
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);
        ans += backtrack(root.left, prefixSum, currentSum, target);
        ans += backtrack(root.right, prefixSum, currentSum, target);
        prefixSum.put(currentSum, prefixSum.get(currentSum) - 1);
        return ans;
    }


    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        int ans = rootSum(root, targetSum);
        ans += pathSum(root.left, targetSum);
        ans += pathSum(root.right, targetSum);
        return ans;
    }

    public int rootSum(TreeNode root, int target) {
        int ret = 0;
        if (root == null) return 0;
        int val = root.val;
        if (val == target) {
            ret++;
        }
        ret += rootSum(root.left, target - val);
        ret += rootSum(root.right, target - val);
        return ret;
    }


}
