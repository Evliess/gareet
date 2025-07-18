package org.example;

import leetcode.TreeNode;

import java.util.Arrays;

public class Leet108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int mid = nums.length >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        root.left = sortedArrayToBST(left);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.right = sortedArrayToBST(right);
        return root;
    }

    public TreeNode help(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = help(nums, left, mid);
        root.right = help(nums, mid + 1, right);
        return root;
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return search(nums, target, left, mid - 1);
        else return search(nums, target, mid + 1, right);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int ans = search(a, 44, 0, a.length - 1);
        System.out.println(ans);
    }

}
