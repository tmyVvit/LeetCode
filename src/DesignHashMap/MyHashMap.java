package DesignHashMap;

//706. Design HashMap

public class MyHashMap {

    /** Initialize your data structure here. */
    public MyHashMap() {
        first = new Node();
        last = new Node();
        first.next = last;
    }

    private Node first;
    private Node last;

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node sameKeyNode = findByKey(key);
        if(sameKeyNode != null) {
            sameKeyNode.value = value;
        } else {
            Node node = new Node(key, value);
            node.next = first.next;
            first.next = node;
        }
    }

    private Node findByKey(int key) {
        Node node = first.next;
        while(node != last) {
            if(node.key == key) return node;
            node = node.next;
        }
        return null;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node sameKey = findByKey(key);
        if(sameKey == null) return -1;
        return sameKey.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node pre = first;
        Node node = first.next;
        while(node != last) {
            if(node.key == key) {
                pre.next = node.next;
                return;
            }
            pre = node;
            node = node.next;
        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next  = null;
        }

        public Node() {
        }

        public Node getNext() {
            return next;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */