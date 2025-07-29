package leetcode;

public class Leet142 {

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = isCycle(head);
        if (slow == null) return null;
        ListNode target = head;
        while (slow != target) {
            slow = slow.next;
            target = target.next;
        }
        return target;
    }

    public static ListNode isCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return fast;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;
        System.out.println(isCycle(head).val);

    }
}
