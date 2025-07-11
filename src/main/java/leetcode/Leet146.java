package leetcode;

import java.util.HashMap;
import java.util.Map;

class CNode {
    CNode prev;
    CNode next;
    int key;
    int val;

    CNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    CNode() {
    }
}

class LRUCache {
    CNode head;
    CNode tail;
    Map<Integer, CNode> hash;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.hash = new HashMap<>(capacity);
        this.capacity = capacity;
        head = new CNode();
        tail = new CNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CNode node = hash.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    private void moveToHead(CNode node) {
        delNode(node);
        appendHead(node);
    }

    private void delNode(CNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private CNode delTail() {
        CNode res = tail.prev;
        delNode(res);
        return res;
    }


    private void appendHead(CNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void put(int key, int value) {
        CNode target = hash.get(key);
        if (target != null) {
            target.val = value;
            moveToHead(target);
        } else {
            if (size == this.capacity) {
                int tailVal = delTail().val;
                size--;
                hash.remove(tailVal);
            }
            CNode node = new CNode(key, value);
            hash.put(key, node);
            appendHead(node);
            size++;
        }
    }
}


public class Leet146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        System.out.println(cache.get(1));
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
