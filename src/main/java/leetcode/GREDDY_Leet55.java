package leetcode;

public class GREDDY_Leet55 {

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == 0) return false;
        int maxLen = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(maxLen, i + nums[i]);
                if (maxLen >= len - 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 4};
        System.out.println(canJump(a));
    }
}
