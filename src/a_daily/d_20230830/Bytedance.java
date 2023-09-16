package a_daily.d_20230830;

public class Bytedance {

    public static void main(String[] args) {

        Node node = buildList(10);
        System.out.println(play(node));
    }

    static int play(Node node) {
        Node curr = node;
        Node next = curr.next;
        int i = 2;
        while (curr.val != next.val) {
            // curr
            if (i != 3) {
                i++;
                curr = next;
                next = curr.next;
            } else {
                if (next.next.val == curr.val) {
                    return curr.val;
                }
                curr.next = next.next;
                next = curr.next;
                i = 1;
            }
        }
        return curr.val;
    }

    static Node buildList(int n) {
        Node head = new Node();
        Node curr = head;
        for (int i = 1; i <= n; i++) {
            Node node = new Node();
            node.val = i;
            curr.next = node;
            curr = node;
        }
        curr.next = head.next;
        return head.next;
    }


    static class Node {
        int val;
        Node next;
    }

}

