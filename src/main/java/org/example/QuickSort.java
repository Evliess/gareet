package org.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort {

    public static void sort(int[] nums, int start, int end) {
        if (start >= end || nums == null) return;
        int pos = getPos(nums, start, end);
        sort(nums, start, pos - 1);
        sort(nums, pos + 1, end);
    }

    public static int getPos(int[] nums, int start, int end) {
        int rIndex = ThreadLocalRandom.current().nextInt(start, end + 1);
        swap(nums, start, rIndex);
        int pivot = nums[start];
        int left = start;
        while (start < end) {
            //从右边找比pivot小
            while (start < end && nums[end] >= pivot) {
                end--;
            }
            //从左边找比pivot大
            while (start < end && nums[start] <= pivot) {
                start++;
            }
            if (start < end) {
                swap(nums, start, end);
            }
        }
        swap(nums, left, end);
        return end;
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void insertSort(int[] nums) {
        if (nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i]; //必须将当前的值保存出来，因为后面排序好的数字会将这个位置的值覆盖掉
            int sortedPos = i - 1;
            while (sortedPos >= 0 && nums[sortedPos] > curr) {
                //将排序好的最后一个元素右移一位
                nums[sortedPos + 1] = nums[sortedPos];
                sortedPos--;
            }
            nums[sortedPos + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 22, 22, 11, 4, 3, 2, 1, 1, 100, 20};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
//        insertSort(a);
//        System.out.println(a);


    }

}
