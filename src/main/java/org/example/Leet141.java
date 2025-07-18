package org.example;

import leetcode.ListNode;

public class Leet141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null //必须检查fast指针
                && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next; //这一步fast有可能为空
            if (slow == fast) return true;
        }
        return false;
    }
}
