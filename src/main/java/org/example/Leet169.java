package org.example;

public class Leet169 {

    public int majorityElement(int[] nums) {
        int target = nums[0];
        int count = 0;
        for (int num : nums) {
            if (target == num) count++;
            else {
                if (count-- < 0) {
                    target = num;
                }
            }
        }
        return target;
    }
}
