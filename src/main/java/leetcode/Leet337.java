package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leet337 {

    public static int rob(TreeNode root) {
        return wrongSolution(root);
    }


    public static int wrongSolution(TreeNode root) {
        if (root == null) return 0;
        List<List<Integer>> levels = traverse(root);
        int odd = 0;
        int even = 0;
        for (int i = 0; i < levels.size(); i++) {
            List<Integer> level = levels.get(i);
            if ((i & 1) == 1) {
                for (Integer l : level) {
                    odd += l;
                }
            } else {
                for (Integer l : level) {
                    even += l;
                }
            }
        }
        return Math.max(odd, even);
    }

    public static List<List<Integer>> traverse(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                size--;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levels.add(list);
        }
        return levels;
    }


    public static void main(String[] args) {

    }


}
