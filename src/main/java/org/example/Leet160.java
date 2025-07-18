package org.example;

import leetcode.ListNode;

public class Leet160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pa == null ? headA : pb.next;
        }
        return pa;
    }
}

