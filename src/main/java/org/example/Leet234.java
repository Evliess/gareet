package org.example;


import leetcode.ListNode;

//Solution1 使用stack
//Solutions2 反转链表
//双指针 反转mid+1开始处的链表
public class Leet234 {

    public boolean isPalindrome1(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = reverse(slow);
        while (prev != null) {
            if (prev.val != head.val) return false;
            prev = prev.next;
            head = head.next;
        }
        return true;
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        ListNode head1 = reverse(head);
        while (head != null) {
            if (head1.val != head.val) {
                return false;
            } else {
                head = head.next;
                head1 = head1.next;
            }
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode curr, prev = null;
        curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
