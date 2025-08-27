package org.example;

import java.util.Arrays;

public class Test {


    public static void insertsort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int curr = nums[i];
            int sorted = i - 1;
            while (sorted >= 0 && nums[sorted] > curr) {
                nums[sorted + 1] = nums[sorted];
                sorted--;
            }
            nums[sorted + 1] = curr;
        }
    }

    public static void mergesort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int start = 0;
        int end = nums.length;
        int mid = start + (end - start) / 2;
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid, end);
        mergesort(left);
        mergesort(right);
        merge(nums, left, right);
    }

    public static void merge(int[] target, int[] a, int[] b) {
        int pt = 0;
        int pa = 0;
        int pb = 0;
        while (pa < a.length && pb < b.length) {
            if (a[pa] < b[pb]) target[pt++] = a[pa++];
            else target[pt++] = b[pb++];
        }
        while (pa < a.length) target[pt++] = a[pa++];
        while (pb < b.length) target[pt++] = b[pb++];
    }

    public static void quicksort(int[] nums, int start, int end) {
        if (nums == null || start >= end) return;
        int pos = getPos(nums, start, end);
        quicksort(nums, start, pos - 1);
        quicksort(nums, pos + 1, end);
    }

    public static int getPos(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start;
        while (start < end) {
            while (nums[end] >= pivot) end--;
            while (nums[start] <= pivot) start++;
            if (start < end) swap(nums, start, end);
        }
        swap(nums, left, end);
        return end;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 4, 5};
//        insertsort(nums);
//        quicksort(nums, 0, nums.length - 1);
        mergesort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
