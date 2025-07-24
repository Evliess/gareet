package leetcode;

public class Leet19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        curr = dummy;
        int count = len - n - 1;
        while (count > 0) {
            curr = curr.next;
            count--;
        }
        //此时curr正好等于要删除节点的前一个节点
        curr.next = curr.next.next;
        return dummy.next;
    }
}
