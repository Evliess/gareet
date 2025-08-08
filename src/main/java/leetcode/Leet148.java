package leetcode;

import java.util.PriorityQueue;

// 148. 排序链表
public class Leet148 {


    public ListNode sortList(ListNode head) {
        //这个判断是递归退出的条件，很重要
        if (head == null || head.next == null)
            return head;
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null; //断开链表是将mid.next设置为null
        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        return merge(left, right);
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                curr.next = head1;
                head1 = head1.next;
            } else {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }
        if (head1 != null) {
            curr.next = head1;
        }
        if (head2 != null) {
            curr.next = head2;
        }
        return dummy.next;
    }

    public ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast.next != null) fast = fast.next; //为了保证二分的时候，左右节点数量均衡，这样slow就慢一步
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode solution(ListNode head) {
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


    }
}
