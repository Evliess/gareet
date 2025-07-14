package org.example;

import leetcode.TreeNode;

public class Leet543 {

    public int diameterOfBinaryTree(TreeNode root) {
        int left = maxHeight(root.left);
        int right = maxHeight(root.right);
        return left + right;
    }

    public int maxHeight(TreeNode node) {
        if (node == null) return 0;
        int l = maxHeight(node.left);
        int r = maxHeight(node.right);
        return Math.max(l, r) + 1;
    }
}
