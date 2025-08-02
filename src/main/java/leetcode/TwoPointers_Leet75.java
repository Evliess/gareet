package leetcode;

//75. 颜色分类
public class TwoPointers_Leet75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                //先交换1
                swap(nums, p1, i);
                p1++;
            } else if (nums[i] == 0) {
                //交换0
                swap(nums, p0, i);
                //当0的位置小于1的时候
                if (p0 < p1) {
                    //交换1
                    swap(nums, p1, i);
                }
                //同时移动0和1的指针
                p0++;
                p1++;
            }
        }

    }

    public void solutions1(int[] nums) {
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
