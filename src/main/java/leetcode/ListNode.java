package leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String traverse(ListNode head) {
        if (head == null) return null;
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val).append(",");
            head = head.next;
        }
        return sb.substring(0, sb.length() - 1);
    }
}
