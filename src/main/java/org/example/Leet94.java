package org.example;


import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//94. 二叉树的中序遍历
public class Leet94 {

    public static void main(String[] args) {
        Leet94 l = new Leet94();
        TreeNode tree = l.build();
        List<Integer> ans = l.inorderTraversal(tree);
        System.out.println("ans: " + ans);
        ans = l.preorderTraversal(tree);
        System.out.println("ans: " + ans);
        ans = l.postorderTraversal(tree);
        System.out.println("ans: " + ans);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                ans.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack0 = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        if (root == null) return ans;
        stack0.push(root);
        while (!stack0.isEmpty()) {
            TreeNode curr = stack0.pop();
            stack1.push(curr);
            if (curr.left != null) stack0.push(curr.left);
            if (curr.right != null) stack0.push(curr.right);
        }
        while (!stack1.isEmpty()) {
            ans.add(stack1.pop().val);
        }

        return ans;
    }

    public TreeNode build() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(12);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(22);
        return root;
    }
}


