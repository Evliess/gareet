package org.example;


// 务必学习Leet146的实现
public class DeLink {

    DeLink prev;
    DeLink next;
    DeLink tail;
    int val;
    int size;

    DeLink(int val) {
        this.val = val;
        size++;
    }

    public static void print(DeLink l) {
        if (l == null) return;
        while (l != null) {
            System.out.println(l.val);
            l = l.next;
        }
    }

    public static void printForward(DeLink l) {
        if (l == null) return;
        DeLink tail = l.tail;
        while (tail != null) {
            System.out.println(tail.val);
            tail = tail.prev;
        }
    }

    public static DeLink addHead(DeLink l, int val) {
        if (l == null) return null;
        DeLink node = new DeLink(val);
        l.prev = node;
        node.next = l;
        node.tail = l.tail;
        l.tail = null;
        node.size = l.size;
        node.size++;
        return node;
    }

    public static DeLink deleteByVal(DeLink l, int val) {
        if (l == null) return null;
        DeLink curr = l;
        while (curr != null) {
            if (curr.val == val) {
                // if curr is head, then need to update head, tail and size
                if (curr.prev == null) {
                    DeLink node = curr.next;
                    node.tail = curr.tail;
                    node.prev = null;
                    node.size = curr.size;
                    node.size--;
                    curr.next = null;
                    return node;
                }
                // if curr is tail, then need to update l.tail and size
                if (curr.next == null) {
                    DeLink tail = curr.prev;
                    tail.next = null;
                    l.tail = tail;
                    l.size--;
                    return l;
                }
                DeLink prev = curr.prev;
                DeLink next = curr.next;
                prev.next = next;
                next.prev = prev;
                l.size--;
                return l;
            } else {
                curr = curr.next;
            }
        }
        return l;
    }

    public static DeLink deleteByPos(DeLink l, int pos) {
        if (l == null || pos < 0 || pos > l.size) return l;
        // delete head
        if (pos == 0) {
            DeLink node = l.next;
            node.tail = l.tail;
            node.prev = null;
            node.size = l.size;
            node.size--;
            l.next = null;
            return node;
        }
        if (pos == l.size) {
            DeLink tail = l.tail;
            l.tail = tail.prev;
            l.tail.next = null;
            l.size--;
            return l;
        }
        DeLink target = l;
        while (pos-- > 0) {
            target = target.next;
        }
        DeLink prev = target.prev;
        DeLink next = target.next;
        prev.next = next;
        next.prev = prev;
        l.size--;
        return l;


    }

    public static DeLink insert(DeLink l, int pos, int val) {
        if (l == null || pos < 0) return l;
        if (pos == 0) return addHead(l, val);
        if (pos == l.size) return addTail(l, val);
        DeLink target = l;
        while (pos > 0) {
            target = target.next;
            pos--;
        }
        DeLink node = new DeLink(val);
        DeLink tprve = target.prev;
        tprve.next = node;
        node.next = target;
        node.prev = tprve;
        l.size++;
        return l;
    }

    public static DeLink addTail(DeLink l, int val) {
        if (l == null) return null;
        DeLink node = new DeLink(val);
        DeLink tail = l.tail;
        tail.next = node;
        node.prev = tail;
        l.tail = node;
        l.size++;
        return l;
    }


    public static DeLink build(int[] nums) {
        if (nums.length == 0) return null;
        DeLink head = new DeLink(nums[0]);
        DeLink curr = head;
        curr.tail = head;
        for (int i = 1; i < nums.length; i++) {
            DeLink node = new DeLink(nums[i]);
            curr.next = node;
            node.prev = curr;
            curr = node;
            if (i == nums.length - 1) {
                head.tail = node;
            }
            head.size++;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        DeLink link = build(nums);
        link = addHead(link, 0);
        link = addTail(link, 6);
        link = insert(link, 7, -1);
        link = deleteByVal(link, 3);
        link = deleteByPos(link, 4);
        print(link);
        System.out.println("size: " + link.size);
    }

}
