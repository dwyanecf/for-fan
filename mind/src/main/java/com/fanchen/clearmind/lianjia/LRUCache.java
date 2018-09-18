package com.fanchen.clearmind.lianjia;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public int capacity = 0;
    public int count = 0;
    public Map<Integer, Node> map;
    public Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
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
        Node n = map.get(key);
        if (n == null) {
            return -1;
        } else {
            update(n);
            return n.value;
        }
    }

    public void put(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.value = value;
            update(n);
        } else {
            Node fresh = new Node(key, value);
            count++;
            map.put(key, fresh);
            add(fresh);
            if (count > capacity) {
                Node toBeDeleted = tail.pre;
                remove(toBeDeleted);
                map.remove(toBeDeleted.key);
                count--;
            }
        }
    }

    class Node {
        Node pre = null;
        Node next = null;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        Node() {
            this.key = 0;
            this.value = 0;
        }
    }
}


