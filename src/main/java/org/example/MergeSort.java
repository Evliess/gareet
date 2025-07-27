package org.example;

import java.util.Arrays;

public class MergeSort {


    public static void sort(int[] nums) {
        if (nums.length > 1) {
            //将数组分为两半
            int mid = nums.length >> 1;
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);
            //递归到left和right数组的大小都为1，然后merge
            sort(left);
            sort(right);
            merge(nums, left, right);

        }
    }

    public static void merge(int[] target, int[] a, int[] b) {
        int pa = 0, pb = 0, pt = 0;
        while (pa < a.length && pb < b.length) {
            if (a[pa] < b[pb]) {
                target[pt++] = a[pa++];
            } else {
                target[pt++] = b[pb++];
            }
        }
        //数组a还有剩余元素
        while (pa < a.length) target[pt++] = a[pa++];
        //数组b还有剩余元素
        while (pb < b.length) target[pt++] = b[pb++];
    }

    public static void main(String[] args) {
        int[] c = new int[]{11, 2, 3, 4};
        sort(c);
        System.out.println(c);


    }
}
