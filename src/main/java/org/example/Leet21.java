package org.example;

import leetcode.ListNode;

public class Leet21 {

    public ListNode solution1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head, curr;
        ListNode p1 = list1;
        ListNode p2 = list2;
        if (p1.val < p2.val) {
            head = p1;
            p1 = p1.next;
        } else {
            head = p2;
            p2 = p2.next;
        }
        curr = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        if (p1 != null) curr.next = p1;
        if (p2 != null) curr.next = p2;
        return head;
    }

    public ListNode solution(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        return solution1(list1, list2);
        return solution(list1, list2);
    }
}
