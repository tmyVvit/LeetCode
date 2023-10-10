package a_daily.d_20231010;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcode {

    public static void main(String[] args) {
        int[] barcodes = new int[]{1,1,1,1,2,2,3,3};
        DistantBarcode db = new DistantBarcode();
        int[] res = db.rearrangeBarcodes(barcodes);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public int[] rearrangeBarcodes0(int[] barcodes) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int num : barcodes) {
            map.computeIfAbsent(num, k -> new int[]{k, 0});
            map.get(num)[1]++;
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        q.addAll(map.values());

        int i = 0;
        while (!q.isEmpty()) {
            int[] node = q.poll();
            while (node[1] > 0) {
                barcodes[i] = node[0];
                node[1]--;
                i += 2;
                if (i >= barcodes.length) {
                    i = 1;
                }
            }
        }
        return barcodes;
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Node> map = new HashMap<>();

        for (int num : barcodes) {
            map.computeIfAbsent(num, k -> new Node(num));
            map.get(num).count++;
        }

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.addAll(map.values());

        Node node = q.poll();
        int i = 0;
        while (i < barcodes.length) {
            barcodes[i++] = node.num;
            node.count--;
            Node next = q.poll();
            if (node.count > 0) {
                q.add(node);
            }
            node = next;
        }

        return barcodes;

    }


    static class Node implements Comparable<Node>  {
        int num;
        int count;

        Node(int num) {
            this.num = num;
            this.count = 0;
        }

        @Override
        public int hashCode() {
            return num;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node node = (Node) o;
                return node.num == num;
            }
            return false;
        }

        @Override
        public int compareTo(Node o) {
            return o.count - count;
        }

        @Override
        public String toString() {
            return "{num=" + num + ", count=" + count + "}";
        }
    }
}
