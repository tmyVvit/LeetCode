package Huawei;

public class ReverseLinkedListBetween {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode arrayToList(int[] arr) {
        ListNode head = new ListNode();
        ListNode pre = head;
        for (int num : arr) {
            ListNode node = new ListNode(num);
            pre.next = node;
            pre = node;
        }
        return head.next;
    }

    public void printList(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedListBetween reverse = new ReverseLinkedListBetween();
        int[] arr = {1,2,3,4,5};
        ListNode origin = reverse.arrayToList(arr);
        reverse.printList(origin);
        ListNode rev = reverse.reverseBetween(origin, 2, 4);
        reverse.printList(rev);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode root = new ListNode();
        root.next = head;
        int idx = 1;
        ListNode pre = root, curr = root.next, startNode = null, leftNode = null;
        while (curr != null) {
            if (idx < left) {
                pre = curr;
                curr = curr.next;
            } else if (idx == left) {
                startNode = pre;
                leftNode = curr;
                pre = curr;
                curr = curr.next;
            } else if (idx > left && idx <= right) {
                ListNode tmp = curr;
                curr = curr.next;
                tmp.next = pre;
                pre = tmp;
            } else {
                break;
            }
            idx++;
        }
        startNode.next = pre;
        leftNode.next = pre.next;

        return root.next;
    }
}
