package leetcode;

import java.util.Arrays;

public class Leet416 {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //sum 如果是奇数，那么一定不可分
        if ((sum & 1) == 1) return false;
        sum = sum >> 1;
        Arrays.sort(nums);
        int tmp = 0;
        for (int num : nums) {
            if (tmp < sum) {
                tmp += num;
                if (tmp == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 1, 1};
        System.out.println(canPartition(nums));
    }
}
