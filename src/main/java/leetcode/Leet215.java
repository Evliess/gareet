package leetcode;

import java.util.PriorityQueue;

public class Leet215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.poll().intValue();


    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(12);
        queue.offer(5);
        queue.offer(8);
        queue.offer(7);
        queue.offer(13);
        queue.offer(11);
        queue.offer(6);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
