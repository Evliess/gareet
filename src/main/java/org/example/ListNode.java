package org.example;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode build(int[] nums) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            head.next = node;
            head = node;
        }
        return dummy.next;
    }


    public void sort(ListNode head1, ListNode head2) {

    }


    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3};
        ListNode head = ListNode.build(nums);
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        ListNode head2 = slow.next;
        slow.next = null;
    }
}
