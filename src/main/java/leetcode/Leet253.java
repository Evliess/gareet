package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * <p>
 * 示例 1：
 * <p>
 * text
 * 输入: intervals = [[0,30],[5,10],[15,20]]
 * 输出: 2
 * 示例 2：
 * <p>
 * text
 * 输入: intervals = [[7,10],[2,4]]
 * 输出: 1
 */
public class Leet253 {
    public int minMeetingRooms(int[][] intervals) {
        int ans = 0;
        if (intervals == null || intervals.length == 0) return ans;
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            return a[0] - b[0];
        });

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            //开始时间大于结束时间
            if (curr[0] > queue.peek()) {
                queue.poll();
            } else {
                queue.offer(curr[1]);
            }
        }
        return queue.size();
    }
}
