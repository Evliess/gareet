package leetcode;

import java.util.HashMap;
import java.util.Map;

public class DP_DFS_Leet337 {

    Map<TreeNode, Integer> selected = new HashMap<>();
    Map<TreeNode, Integer> noselected = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return Math.max(selected.getOrDefault(root, 0),
                noselected.getOrDefault(root, 0));

    }


    public int[] solution(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = solution(root.left);
        int[] right = solution(root.right);
        int selected = root.val + left[1] + right[1];
        int noselected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, noselected};
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        dfs(root.right);
        //root.val + 不选左 + 不选右子树
        selected.put(root, root.val +
                noselected.getOrDefault(root.left, 0) + noselected.getOrDefault(root.right, 0));
        //不选根节点 Math.max(Math.max(选左，不选左) + Math.max(选右，不选右))
        noselected.put(root,
                Math.max(selected.getOrDefault(root.left, 0), noselected.getOrDefault(root.left, 0))
                        + Math.max(selected.getOrDefault(root.right, 0),
                        noselected.getOrDefault(root.right, 0)));
    }
}
