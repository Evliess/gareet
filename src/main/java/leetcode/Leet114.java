package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet114 {

    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        preorderTraverse(root, queue);
        while (queue.size() > 1) {
            TreeNode curr = queue.poll();
            curr.left = null;
            root.right = curr;
            root = root.right;
        }
    }

    public void preorderQueue(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            System.out.println(curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }

    public void preorderTraverse(TreeNode root, Queue<TreeNode> nodes) {
        if (root == null) return;
        nodes.offer(root);
        preorderTraverse(root.left, nodes);
        preorderTraverse(root.right, nodes);
    }
}
