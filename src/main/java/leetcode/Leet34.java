package leetcode;

public class Leet34 {

    public static int[] searchRange(int[] nums, int target) {
        int mid = binarySearch(nums, target);
        int left = mid;
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        int right = mid;
        while (right < nums.length && nums[right] == target) {
            right++;
        }
        return new int[]{++left, --right};
    }


    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 4, 4, 4, 4, 6};
        int[] ans = searchRange(nums, 4);
        System.out.println(ans[0] + ":" + ans[1]);
    }


}
