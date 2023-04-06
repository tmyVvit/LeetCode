package mergeKSortedLists;

import common.ListNode;

public class Solution {

    // 可以建立一个最小堆，每次取堆顶的元素
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Heap heap = new Heap(lists);
        ListNode head = heap.getAndRemove();
        if (head == null) {
            return head;
        }
        ListNode tail = head;
        ListNode node;
        while ((node = heap.getAndRemove()) != null) {
            tail.next = node;
            tail = node;
        }
        return head;
    }

    private static class Heap {
        private final int size;
        private int last = -1;
        private final ListNode[] heap;

        Heap(ListNode[] heap) {
            this.heap = heap;
            this.size = heap.length;
            for (ListNode node : heap) {
                if (node != null) {
                    last++;
                }
            }

            for (int i = size - 1; i >= 0; i--) {
                down(i);
            }
        }

        // 每次取堆顶的元素，并将堆顶的后续节点插入堆中
        ListNode getAndRemove() {
            if (last == -1) {
                return null;
            }
            ListNode node = heap[0];
            if (node == null) {
                return node;
            }

            ListNode next = node.next;
            heap[0] = next;
            down(0);
            if (next == null) {
                last--;
            }
            return node;
        }

        void down(int i) {
            int m;
            while ((m = 2 * i + 1) < size) {
                if (m + 1 < size && compare(heap[m+1], heap[m]) < 0) {
                    m++;
                }
                if (compare(heap[i], heap[m]) > 0) {
                    swap(i, m);
                }
                i = m;
            }
        }

        int compare(ListNode n1, ListNode n2) {
            if (n1 == null && n2 == null) {
                return 0;
            }
            if (n1 == null) {
                return 1;
            }
            if (n2 == null) {
                return -1;
            }
            return Integer.compare(n1.val, n2.val);
        }

        void swap(int i, int j) {
            ListNode tmp = heap[i];
            heap[i] = heap[j];
            heap[j] = tmp;
        }

    }

}
