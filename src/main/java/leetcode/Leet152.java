package leetcode;

public class Leet152 {

    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = 1;
            for (int j = i; j < nums.length; j++) {
                curr *= nums[j];
                max = Math.max(curr, max);
            }
        }
        return max;
    }

    public static int maxProduct0(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr * nums[i]);
            max = Math.max(max, curr);
        }
        return max;
    }


    public static void main(String[] args) {
        int ans = maxProduct0(new int[]{-2, 3, 2, -4});
        System.out.println(ans);
    }
}
