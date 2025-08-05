package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leet337 {
    Map<TreeNode, Integer> selected = new HashMap<>();
    Map<TreeNode, Integer> noselected = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(selected.getOrDefault(root, 0), noselected.getOrDefault(root, 0));
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        //先看看左右两边，再决定如何选择
        dfs(root.left);
        dfs(root.right);
        //选择
        selected.put(root, root.val + noselected.getOrDefault(root.left, 0) + noselected.getOrDefault(root.right, 0));
        //不选择
        noselected.put(root, Math.max(selected.getOrDefault(root.left, 0), noselected.getOrDefault(root.right, 0)) + Math.max(selected.getOrDefault(root.right, 0), noselected.getOrDefault(root.right, 0)));
    }

    public static void main(String[] args) {

    }


}
