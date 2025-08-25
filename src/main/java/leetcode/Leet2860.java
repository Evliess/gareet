package leetcode;

import java.util.Arrays;
import java.util.List;

public class Leet2860 {

    public static int countWays(List<Integer> nums) {
        if (nums == null)
            return 0;
        Integer[] arr = nums.toArray(new Integer[0]);
        Arrays.sort(arr);
        int count = 0;
        int len = arr.length;
        if (arr[0] > 0)
            count++;
        for (int i = 1; i < len; i++) {
            if (arr[i - 1] < i && i < arr[i])
                count++;
        }
        if (arr[len - 1] < len)
            count++;
        return count;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 1);
        System.out.println(countWays(nums));
    }
}
