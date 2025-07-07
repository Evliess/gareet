package leetcode;

public class Leet206 {

    // 0-->1--2
    // 2-->1-->0
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    public static ListNode build(int n) {
        ListNode root = new ListNode(0);
        ListNode head = root;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            head.next = node;
            head = node;
        }
        return root;
    }

    public static void print(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = build(3);
//        print(root);
        ListNode ans = reverseList(root);
        print(ans);
    }
}
