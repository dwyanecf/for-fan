package com.fanchen.clearmind.lianjia;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int count = 0;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public void add(Node n) {
        Node second = head.next;
        head.next = n;
        second.pre = n;
        n.pre = head;
        n.next = second;
    }

    public void remove(Node n) {
        Node before = n.pre;
        Node after = n.next;
        before.next = after;
        after.pre = before;
    }

    public void update(Node n) {
        remove(n);
        add(n);
    }

    public int get(int key) {
        Node cur = map.get(key);
        if (cur != null) {
            update(cur);
            return cur.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        Node cur = map.get(key);
        if (cur != null) {
            cur.value = value;
            update(cur);
        } else {
            Node n = new Node(key, value);
            count++;
            map.put(key, n);
            add(n);
            if (capacity < count) {
                Node deNode = tail.pre;
                remove(deNode);
                count--;
                map.remove(deNode.key);
            }
        }
    }

    class Node {
        Node pre;
        Node next;
        int value;
        int key;

        Node(int key, int value) {
            pre = null;
            next = null;
            this.key = key;
            this.value = value;
        }

        Node() {
            pre = null;
            next = null;
            key = 0;
            value = 0;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

