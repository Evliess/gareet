package org.example;

import leetcode.TreeNode;

//TODO
public class HeapSort {
    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] a = new int[]{1, 3, 2, 10, 9};
//        hs.createMaxHeap(a);
        hs.swap(a, 0, 1);
        System.out.println(1);
    }

    public TreeNode createMaxHeap(int[] nums) {
        if (nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int parent;
            int parentPos = (i + 1) / 2 - 1;
            if (parentPos < 0) {
                parent = nums[0];
                parentPos = 0;
            } else {
                parent = nums[parentPos];
            }
            if (curr > parent) swap(nums, i, parentPos);
            while (curr > parent) {
                int pPos = (parentPos + 1) / 2 - 1;
                if (pPos < 0) pPos = 0;
                parent = nums[pPos];
                swap(nums, parentPos, pPos);
                parentPos = pPos;

            }
        }
        System.out.println("1");
        return null;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int remove(TreeNode tree) {
        return -1;
    }
}
