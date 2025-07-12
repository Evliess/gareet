package org.example;


// 务必学习Leet146的实现
class DeNode {
    DeNode prev;
    DeNode next;
    int val;

    DeNode() {
    }

    DeNode(int val) {
        this.val = val;
    }
}

public class DeLink {

    DeNode head;
    DeNode tail;
    int size;
    int capacity;

    DeLink(int capacity) {
        this.capacity = capacity;
        head = new DeNode();
        tail = new DeNode();
        head.next = tail;
        tail.prev = head;
    }


    public void print() {
        if (head == null) return;
        DeNode node = head.next;
        while (node != null && node != tail) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void printForward() {
        if (head == null) return;
        DeNode node = tail.prev;
        while (node != null && node != head) {
            System.out.println(node.val);
            node = node.prev;
        }
    }

    public void appendTail(DeNode node) {
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        this.size++;
    }

    public void appendHead(DeNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        this.size++;
    }

    public void delNode(DeNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int delTail() {
        DeNode prev = tail.prev;
        delNode(prev);
        this.size--;
        return prev.val;
    }

    public void build(int[] nums) {
        if (nums.length < 1) return;
        for (int i : nums) {
            DeNode node = new DeNode(i);
            appendHead(node);
            this.size++;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        DeLink link = new DeLink(3);
        link.build(nums);
//        link.print();
//        System.out.println("size: " + link.size);
//        link.appendTail(new DeNode(-5));
//        link.print();
        link.appendHead(new DeNode(-1));
        link.print();
        System.out.println("size: " + link.size);
    }

}
