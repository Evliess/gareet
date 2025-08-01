package org.example;

import leetcode.TreeNode;

public class Leet101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val &&
                check(left.left, right.right) && check(left.right, right.left);
    }

}
