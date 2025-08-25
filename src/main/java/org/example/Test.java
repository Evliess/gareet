package org.example;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Test {

    public static void quicksort(int[] nums, int start, int end) {
        if (nums == null || start >= end) return;
        int pos = getPos(nums, start, end);
        quicksort(nums, start, pos - 1);
        quicksort(nums, pos + 1, end);
    }

    public static int getPos(int[] nums, int start, int end) {
        int random = ThreadLocalRandom.current().nextInt(start, end + 1);
        swap(nums, start, random);
        int pivot = nums[start];
        int left = start;
        while (start < end) {
            while (start < end && nums[end] >= pivot) end--;
            while (start < end && nums[start] <= pivot) start++;
            if (start < end) {
                swap(nums, start, end);
            }
        }
        swap(nums, left, end);
        return end;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //2, 5, 4, 2, 1
    public static void insertsort(int[] nums) {
        if (nums == null || nums.length == 0) return;
        for (int i = 1; i < nums.length; i++) {
            int sortedPos = i - 1;
            int curr = nums[i];
            while (sortedPos >= 0 && nums[sortedPos] > curr) {
                nums[sortedPos + 1] = nums[sortedPos];
                sortedPos--;
            }
            nums[sortedPos + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 4, 2, 1};
//        quicksort(nums, 0, nums.length - 1);
        insertsort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
