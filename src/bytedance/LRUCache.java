package bytedance;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(3, 2);
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        cache.put(4, 3);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    public void print() {
        StringBuilder sb = new StringBuilder("list: \n\t");
        Node node = head;
        int i = 0;
        while (i++ < count) {
            if (i > 1) {
                sb.append(" -> ");
            }
            sb.append(node.key).append(":").append(node.item);
            node = node.next;
        }
        System.out.println(sb);
    }

    // 我们使用一个哈希表和一个双向链表来实现LRUcache
    private final Map<Integer, Node> map;
    // 可以使用虚拟头尾节点，实现更加简单
    private Node head, tail;
    private final int capacity;
    private int count;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            transferToFirst(node);
            return node.item;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            transferToFirst(node);
            node.item = value;
        } else {
            node = new Node(key, value);
            if (count < capacity) {
                putToFirst(node);
                count++;
            } else {
                Node last = removeLast();
                // 从哈希表中删除
                map.remove(last.key, last);
                putToFirst(node);
            }
            map.put(key, node);

        }
    }

    private Node removeLast() {
        Node node = null;
        if (head == tail) {
            node = head;
            head = tail = null;
            return node;
        }
        Node del = tail;
        tail = del.prev;
        tail.next = head;
        head.prev = tail;
        return del;
    }

    private void remove(Node node) {
        if (node == tail) {
            removeLast();
            return ;
        }
        if (node == head) head = node.next;
        Node pre = node.prev, next = node.next;
        pre.next = next;
        next.prev = pre;
    }

    private void transferToFirst(Node node) {
        if (node == head) return;
        remove(node);
        putToFirst(node);
    }

    private void putToFirst(Node node) {
        if (head == null) {
            head = tail = node;
            head.next = head.prev = tail;
        } else {
            Node first = head;
            head = node;
            node.next = first;
            first.prev = node;
            node.prev = tail;
            tail.next = node;
        }
    }

    static final class Node {
        Node prev;
        Node next;
        int key;
        int item;
        Node(){}
        Node(int key, int item) {
            this.item = item;
            this.key = key;
        }
    }

}
