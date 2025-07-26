package leetcode;

import java.util.Stack;

public class TREE_Leet98 {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        long inorderVal = Long.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= inorderVal) return false;
                inorderVal = root.val;
                root = root.right;
            }
        }
        return true;
    }

    public boolean solution(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode node, long low, long high) {
        if (node == null) return false;
        if (node.val <= low || node.val >= high) return false;
        return helper(node.left, low, node.val) && helper(node.right, node.val, high);
    }


    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE > Long.MIN_VALUE);
    }


}
