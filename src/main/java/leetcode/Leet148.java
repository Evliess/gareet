package leetcode;

import java.util.PriorityQueue;

// 148. 排序链表
public class Leet148 {

    public static ListNode sortList(ListNode head) {
        if (head == null) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        while (head != null) {
            queue.offer(head);
            head = head.next;
        }

        ListNode ans = null;
        if (!queue.isEmpty()) {
            ans = queue.poll();
        }
        ListNode curr = ans;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            curr.next = node;
            curr = node;
            if (queue.isEmpty()) {
                curr.next = null; //将最后一个node的指向设置为null
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 4, 3};
        ListNode head = new ListNode(a[0]);
        ListNode curr = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            curr.next = node;
            curr = node;
        }
        System.out.println(head);
        ListNode ans = sortList(head);

    }
}
