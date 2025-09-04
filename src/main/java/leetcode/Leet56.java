package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class Leet56 {


    public static int[][] merge(int[][] intervals) {
        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        stack.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peek();
            int[] curr = intervals[i];
            if (top[1] >= curr[0]) {
                stack.pop();
                stack.push(new int[]{top[0], curr[1]});
            } else {
                stack.push(curr);
            }
        }
        int size = stack.size();
        int[][] ans = new int[size][2];
        while (size > 0) {
            ans[--size] = stack.pop();
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = merge(arr);
        System.out.println(Arrays.toString(ans[0]));
        System.out.println(Arrays.toString(ans[1]));
        System.out.println(Arrays.toString(ans[2]));
    }
}
