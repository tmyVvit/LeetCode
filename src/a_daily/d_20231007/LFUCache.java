package a_daily.d_20231007;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache {

    PriorityQueue<Node> q;
    Map<Integer, Node> map;

    int capacity;

    int opCount = 0;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.q = new PriorityQueue<>(capacity);
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        q.remove(node);
        node.freq++;
        node.opNo = opCount++;
        q.add(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node old = map.get(key);
        if (old == null) {
            Node node;
            if (q.size() == capacity && (node = q.poll()) != null) {
                map.remove(node.key);
            }
            node = new Node(key, value, 1, opCount++);
            map.put(key, node);
            q.add(node);
        } else {
            q.remove(old);
            old.value = value;
            old.freq++;
            old.opNo = opCount++;
            q.add(old);
        }
    }

    private static class Node implements Comparable<Node> {
        int key;
        int value;
        int freq;
        int opNo;

        Node(int key, int value, int freq, int opNo) {
            this.key = key;
            this.value = value;
            this.freq = freq;
            this.opNo = opNo;
        }

        @Override
        public int compareTo(Node o) {
            return freq == o.freq ? opNo - o.opNo : freq - o.freq;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node node = (Node) obj;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return key;
        }
    }
}

