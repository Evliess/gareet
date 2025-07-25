package leetcode;

public class TwoPointers_Leet11 {
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int l = 0;
        int r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int v = r - l;
            int h = Math.min(height[l], height[r]);
            int s = h * v;
            ans = Math.max(ans, s);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 1};
        System.out.println(maxArea(height));
    }

}
