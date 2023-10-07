package a_daily.d_20231007;

import java.util.HashMap;
import java.util.Map;

public class LFUCache2 {

    int capacity;

    Map<Integer, DLinkedList> freqMap;
    Map<Integer, Node> nodeMap;

    int minFreq;

    public LFUCache2(int capacity) {
        this.capacity = capacity;
        this.freqMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.minFreq = 1;
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node);
        if (oldFreq == minFreq && freqMap.get(oldFreq).isEmpty()) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, k -> new DLinkedList()).addFirst(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node old = nodeMap.get(key);
        if (old == null) {
            if (nodeMap.size() == capacity) {
                DLinkedList mlist = freqMap.get(minFreq);
                Node node = mlist.last();
                mlist.remove(node);
                if (mlist.isEmpty()) {
                    freqMap.remove(minFreq);
                }
                nodeMap.remove(node.key);
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            freqMap.computeIfAbsent(node.freq, k -> new DLinkedList()).addFirst(node);
            minFreq = 1;
        } else {
            old.value = value;
            get(key);
        }
    }

    static class Node {
        int key;
        int value;
        int freq;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    static class DLinkedList {
        Node head, tail;

        int size;

        DLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            size++;
        }

        Node last() {
            return tail.pre;
        }

        Node first() {
            return head.next;
        }

        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            size--;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

}
