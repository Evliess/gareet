package leetcode;

public class Leet2 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1)
            tail.next = new ListNode(1);
        return head;
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
