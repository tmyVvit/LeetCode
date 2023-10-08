package a_daily.d_20231008;

import java.util.*;

// https://leetcode-cn.com/problems/stock-price-fluctuation/
public class StockPrice {

    TreeSet<Node> q = new TreeSet<>();
    Map<Integer, Node> map = new HashMap<>();

    int current = 0;

    public StockPrice() {
    }

    public void update(int timestamp, int price) {
        Node old = map.get(timestamp);
        if (old == null) {
            old = new Node(timestamp, price);
        } else {
            q.remove(old);
            old.price = price;
        }
        map.put(timestamp, old);
        q.add(old);
        current = Math.max(current, timestamp);
    }

    public int current() {
        return map.get(current).price;
    }

    public int maximum() {
        return q.last().price;
    }

    public int minimum() {
        return q.first().price;
    }

    static class Node implements Comparable<Node> {
        int timestamp;
        int price;

        Node(int timestamp, int price) {
            this.timestamp = timestamp;
            this.price = price;
        }

        @Override
        public int hashCode() {
            return timestamp;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Node) {
                Node node = (Node) obj;
                return node.timestamp == timestamp;
            }
            return false;
        }

        @Override
        public int compareTo(Node o) {
            return price == o.price ? timestamp - o.timestamp : price - o.price;
        }
    }
}
