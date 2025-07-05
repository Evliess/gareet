package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Leet104 {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size(); //记录当前层的size
            while (size > 0) {
                TreeNode node = queue.poll();
                size--;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans++;
        }
        return ans;
    }

    public int maxDepth0(TreeNode root) {
        if (root == null) return 0;
        int leftH = maxDepth0(root.left);
        int rightH = maxDepth0(root.right);
        return Math.max(leftH, rightH) + 1;
    }
}
