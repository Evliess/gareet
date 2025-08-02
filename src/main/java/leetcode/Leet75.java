package leetcode;

//75. 颜色分类
public class Leet75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p);
                p++;
            }
        }
        for (int i = p; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p);
                p++;
            }
        }
    }

    public static void solution(int[] nums) {
        int cnt0 = 0, cnt1 = 0;
        for (int num : nums) {
            if (num == 0) {
                cnt0++;
            } else if (num == 1) {
                cnt1++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < cnt0) {
                nums[i] = 0;
            } else if (i < cnt0 + cnt1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }

    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 1};
        solution(arr);
    }
}
