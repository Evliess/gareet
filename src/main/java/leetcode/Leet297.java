package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Leet297 {

    public static void main(String[] args) {
        Leet297 l = new Leet297();
        TreeNode tree = l.dfsBuild();
        l.print(tree);
        String vals = l.serialize(tree);
//        System.out.println(vals);

        tree = l.deserialize(vals);
        System.out.println("----");
        l.print(tree);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
//        return dfsTraversal(root, new StringBuilder());
        return bfsTraversal(root, new StringBuilder());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
//        return dfsBuild(queue);
        return bfsBuild(queue);
    }

    public TreeNode bfsBuild(Queue<String> data) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (data.isEmpty() || data.peek().equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data.poll()));
        queue.offer(root);
        while (!queue.isEmpty() && !data.isEmpty()) {
            TreeNode node = queue.poll();
            //build left
            String left = data.poll();
            if (!"null".equals(left)) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            }
            //build right
            if (!data.isEmpty()) {
                String right = data.poll();
                if (!"null".equals(right)) {
                    node.right = new TreeNode(Integer.parseInt(right));
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public TreeNode dfsBuild(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = dfsBuild(queue);
        node.right = dfsBuild(queue);
        return node;
    }

    public String dfsTraversal(TreeNode root, StringBuilder res) {
        if (root == null) {
            res.append("null").append(",");
        } else {
            res.append(root.val).append(",");
            dfsTraversal(root.left, res);
            dfsTraversal(root.right, res);
        }

        return res.substring(0, res.length() - 1);
    }

    public String bfsTraversal(TreeNode root, StringBuilder res) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("null").append(",");
            } else {
                res.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res.substring(0, res.length() - 1);
    }

    public void print(TreeNode tree) {
        if (tree == null) {
            System.out.println("null");
            return;
        } else System.out.println(tree.val);
        print(tree.left);
        print(tree.right);

    }

    public TreeNode dfsBuild() {
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
