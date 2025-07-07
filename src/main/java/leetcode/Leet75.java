package leetcode;

//75. 颜色分类
public class Leet75 {

    public static void sortColors(int[] nums) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 1};
        sortColors(arr);
    }
}
