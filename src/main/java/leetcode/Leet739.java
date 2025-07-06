package leetcode;

import java.util.Stack;

public class Leet739 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (temperatures[i] < temperatures[stack.peek()]) {
                    stack.push(i);
                } else {
                    while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                        int prevIdx = stack.pop();
                        ans[prevIdx] = i - prevIdx;
                    }
                    stack.push(i);
                }

            }
        }
        return ans;
    }


    public static int[] dailyTemperatures1(int[] temperatures) {
        int[] memo = new int[temperatures.length];
        for (int i = 0; i < temperatures.length - 1; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    memo[i] = j - i;
                    break;
                }
            }
        }
        return memo;
    }

    public static void main(String[] args) {
        int[] ans = dailyTemperatures(new int[]{30, 60, 90});
    }
}
