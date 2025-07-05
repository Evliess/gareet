package leetcode;

import java.util.*;

public class Leet105 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        for (int p : preorder) {
            pre.add(p);
        }
        for (int i : inorder) {
            in.add(i);
        }
        return buildTree(pre, in);
    }

    public static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if (!inorder.isEmpty()) {
            int valInPreOrder = preorder.removeFirst();
            TreeNode root = new TreeNode(valInPreOrder);
            int posOfInOrder = inorder.indexOf(valInPreOrder);
            root.left = buildTree(preorder, inorder.subList(0, posOfInOrder));
            root.right = buildTree(preorder, inorder.subList(posOfInOrder + 1, inorder.size()));
            return root;

        }
        return null;

    }

    public static TreeNode build() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t4.right = t7;
        t3.left = t5;
        t3.right = t6;
        t6.left = t8;
        return t1;
    }

    public static void preOrder(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.val);
            preOrder(tree.left);
            preOrder(tree.right);
        }

    }

    public static void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.val);
            inOrder(tree.right);
        }

    }

    public static void main(String[] args) {
//        TreeNode root = build();
//        preOrder(root);
//        System.out.println("------------");
//        inOrder(root);
//
//        List<Integer> list = new LinkedList<>();
//        list.add(1);list.add(2);list.add(3);list.add(4);
//
//        System.out.println(list.indexOf(3));
//        list = list.subList(1, list.size());
//
//        for (int i: list) {
//            System.out.println(i);
//        }

        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        buildTree(pre, in);


    }
}
