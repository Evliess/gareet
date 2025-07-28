package leetcode;

public class BT_Leet494 {

    public static int findTargetSumWays(int[] nums, int target) {
        return backTrack(nums, target, 0);
    }

    public static int backTrack(int[] nums, int target, int index) {
        if (index == nums.length) {
            if (target == 0) return 1;
            else return 0;
        }
        int add = backTrack(nums, target - nums[index], index + 1);
        int subtract = backTrack(nums, target + nums[index], index + 1);
        return add + subtract;
    }

    //下面的写法不推荐，但是方便学习回溯的思路
    public int backtrack(int[] nums, int target, int current, int index) {
        if (index == nums.length) {
            return target == current ? 1 : 0;
        }
        current = current + nums[index];
        int add = backtrack(nums, target, current, index + 1);
        current = current - nums[index];

        current = current - nums[index];
        int sub = backtrack(nums, target, current, index + 1);
        current = current + nums[index]; // 如果实在循环里面，这一步必须写，重置到选择前的状态
        return add + sub;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int ans = findTargetSumWays(nums, 3);
        System.out.println(ans);
    }
}
