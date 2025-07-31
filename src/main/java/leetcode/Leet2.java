package leetcode;

public class Leet2 {


    public ListNode solution(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1)
            tail.next = new ListNode(1);
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        int shiftLeft = 0;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val + shiftLeft;
            if (shiftLeft == 1) shiftLeft = 0;
            if (val >= 10) {
                val = val - 10;
                shiftLeft = 1;
            }
            ListNode curr = new ListNode(val);
            head.next = curr;
            head = curr;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + shiftLeft;
            if (shiftLeft == 1) shiftLeft = 0;
            if (val >= 10) {
                val = val - 10;
                shiftLeft = 1;
            }
            head.next = new ListNode(val);
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int val = l2.val + shiftLeft;
            if (shiftLeft == 1) shiftLeft = 0;
            if (val >= 10) {
                val = val - 10;
                shiftLeft = 1;
            }
            head.next = new ListNode(val);
            head = head.next;
            l2 = l2.next;
        }

        if (shiftLeft == 1) {
            head.next = new ListNode(1);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);

        ListNode head2 = new ListNode(9);
        head2.next = new ListNode(9);

        ListNode ans = addTwoNumbers(head, head2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
