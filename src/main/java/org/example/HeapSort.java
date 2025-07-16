package org.example;

import leetcode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//TODO
public class HeapSort {
    public void shiftUp(int[] nums, int i) {
        int currVal = nums[i];
        int parentPos = (i + 1) / 2 - 1;
        if (parentPos < 0) parentPos = 0;
        int parentVal = nums[parentPos];
        while (currVal > parentVal) {
            swap(nums, i, parentPos);
            i = parentPos;
            parentPos = (parentPos + 1) / 2 - 1;
            if (parentPos < 0) parentPos = 0;
            parentVal = nums[parentPos];
        }
    }

    public TreeNode createMaxHeapTree(int[] nums) {
        if (nums.length == 0) return null;
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(nums[0]);
        map.put(0, root);
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(i, k -> new TreeNode(nums[k]));
            TreeNode node = map.get(i);
            int leftP = 2 * i + 1;
            if (leftP < nums.length) {
                node.left = new TreeNode(nums[leftP]);
                map.put(leftP, node.left);
            }
            if (leftP + 1 < nums.length) {
                node.right = new TreeNode(nums[leftP + 1]);
                map.put(leftP + 1, node.right);
            }
        }
        return root;
    }

    public TreeNode createMaxHeap(int[] nums) {
        if (nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++) {
            shiftUp(nums, i);
        }
        return createMaxHeapTree(nums);
    }

    public String print(TreeNode tree) {
        if (tree == null) return null;
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.append(node.val).append(",");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res.substring(0, res.length() - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void shiftDown(int[] nums, int i) {
        int leftP = 2 * i + 1;
        int leftVal, rightVal, curr, max;
        curr = nums[i];
        if (leftP < nums.length) {
            leftVal = nums[leftP];
            if (leftP + 1 < nums.length) {
                rightVal = nums[leftP + 1];
                max = Math.max(leftVal, rightVal);
                if (curr < max) {
                    if (max == leftVal) {
                        swap(nums, i, leftP);
                        shiftDown(nums, leftP);
                    } else swap(nums, i, leftP + 1);
                }
            } else {
                if (curr < leftVal) swap(nums, i, leftP);
            }
        }
    }

    //堆删除一定是删除堆顶元素
    public int remove(int[] nums) {
        //将堆中最后一个元素放到堆顶
        //如何该元素小于左右节点，进行交换，直到该元素大于左右节点
        int val = nums[0];
        nums[0] = nums[nums.length - 1];
        shiftDown(nums, 0);
        for (int n : nums) {
            System.out.println(n);
        }
        return val;
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] a = new int[]{1, 3, 2, 10, 9};
        a = new int[]{10, 20, 15, 30, 40};
        TreeNode root = hs.createMaxHeap(a);
//        System.out.println(hs.print(root));
        int val = hs.remove(a);
        System.out.println(val);

    }
}
