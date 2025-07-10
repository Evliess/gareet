package leetcode;

import java.util.HashMap;
import java.util.Map;

class CNode {
    CNode prev;
    CNode next;
    CNode tail;
    int key;
    int val;
    int capacity;

    CNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    CNode head;
    Map<Integer, CNode> hash;
    int capacity;

    public LRUCache(int capacity) {
        this.hash = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        CNode node = hash.get(key);
        if (node == null) return -1;

        if (node.prev == null) return node.val; //if this node is head, return val and do nothing
        if (node.next == null) { // if this node is tail, set new tail.next is null and update head.tail
            node.prev.next = null;
            head.tail = node.prev;
        }
        appendHead(node);
        return head.val;
    }

    private int delTail() {
        CNode tail = head.tail;
        head.tail = tail.prev;
        return tail.val;
    }

    private void appendHead(CNode node) {
        if (head == null) {
            head = node;
            head.tail = node;
        } else {
            node.capacity = head.capacity;
            node.next = head;
            node.tail = head.tail;
            head.tail = null;
            node.prev = null;
            head.prev = node;
            head = node;
        }
    }

    public void put(int key, int value) {
        CNode target = hash.get(key);
        if (target != null) {
            target.val = value;
            get(key);
        } else {
            CNode node = new CNode(key, value);
            if (head != null && this.capacity == head.capacity) {
                int tailVal = delTail();
                head.capacity--;
                hash.remove(tailVal);
            }
            appendHead(node);
            head.capacity++;
            hash.put(key, node);
        }
    }
}


public class Leet146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println("size: " + cache.capacity);
    }

}
