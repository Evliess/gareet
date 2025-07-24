package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leet347 {

    class Node {
        public int value;
        public int count;

        public Node(int value, int count) {
            this.value = value;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new PriorityQueue<>(k, (n1, n2) -> n2.count - n1.count);
        for (int num : nums) {
            Node node = null;
            if (map.get(num) == null) {
                node = new Node(num, 1);
                map.put(num, node);
            } else {
                node = map.get(num);
                node.count += 1;
                map.put(num, node);
            }
        }
        for (Integer key : map.keySet()) {
            queue.offer(map.get(key));
        }
        int[] ans = new int[k];
        while (k > 0) {
            ans[k - 1] = queue.poll().value;
            k--;
        }
        return ans;
    }


    public static void main(String[] args) {
        Leet347 l = new Leet347();
        int[] nums = {1, 22, 33, 22, 33, 33, 44, 44, 44};
        int[] ans = l.topKFrequent(nums, 2);
    }
}
