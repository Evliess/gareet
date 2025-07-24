package leetcode;

public class Leet31 {

    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        int j = nums.length - 1;
        //从数组右边找升序的两个数(nums[i]<nums[j])
        while (i >= 0 && nums[i] > nums[j]) {
            i--;
            j--;
        }
        System.out.println(i);
        if (i >= 0) {
            int k = nums.length - 1;
            //从数组右边找大于nums[i]的数
            while (k >= 0 && nums[k] < nums[i]) {
                k--;
            }
            swap(nums, i, k);
            reverse(nums, j + 1, nums.length - 1);
        } else {
            reverse(nums, 0, nums.length - 1);
        }

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        reverse(nums, 0, nums.length - 1);
    }

}
