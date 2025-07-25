package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet114 {

    TreeNode prev;

    public void solution(TreeNode root) {
        if (root == null) return;
        TreeNode right = root.right;
        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
        solution(root.left);
        solution(right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        preorderTraverse(root, queue);
        root = queue.poll();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            root.left = null;
            root.right = curr;
            root = curr;
        }
    }

    public void preorderTraverse(TreeNode root, Queue<TreeNode> nodes) {
        if (root == null) return;
        nodes.offer(root);
        preorderTraverse(root.left, nodes);
        preorderTraverse(root.right, nodes);
    }
}
