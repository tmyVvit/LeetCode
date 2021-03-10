package Ali;

import java.util.Stack;

public class BigNumberAdd {

    public static void main(String[] args) {
        BigNumberAdd add = new BigNumberAdd();
        Node node1 = add.arrToList(new int[]{8,2,3});
        Node node2 = add.arrToList(new int[]{2,3,7});
        add.print(add.add(node1, node2));
    }

    public void print(Node node) {
        Node head = node;
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public Node arrToList(int[] arr) {
        Node head = new Node();
        Node tail = head;
        for (int n : arr) {
            Node node = new Node(n);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }

    public Node add(Node node1, Node node2) {
        if (node1 == null && node2 == null) return node1;
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        // 使用两个栈
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        Node tmp = node1;
        while(tmp != null) {
            stack1.push(tmp.val);
            tmp = tmp.next;
        }
        tmp = node2;
        while (tmp != null) {
            stack2.push(tmp.val);
            tmp = tmp.next;
        }
        int add = 0;
        Node head = new Node();
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int num = stack1.pop() + stack2.pop() + add;
            insertFromHead(head, num%10);
            add = num / 10;
        }
        while(!stack1.isEmpty()) {
            int num = stack1.pop() + add;
            insertFromHead(head, num%10);
            add = 0;
        }

        while(!stack2.isEmpty()) {
            int num = stack2.pop() + add;
            insertFromHead(head, num%10);
            add = 0;
        }
        if (add != 0) {
            insertFromHead(head, add);
        }
        return head.next;
    }

    private void insertFromHead(Node head, int num) {
        Node node = new Node(num);
        Node next = head.next;
        head.next = node;
        node.next = next;
    }

    public Node add2(Node node1, Node node2) {
        if (node1 == null && node2 == null) return node1;
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        Node reverse1 = new Node(0, node1);
        Node reverse2 = new Node(0, node2);
        int len1 = reverse(reverse1);
        int len2 = reverse(reverse2);

        Node big, small;
        big = len1 > len2 ? reverse1 : reverse2;
        small = len1 > len2 ? reverse2 : reverse1;
        coreAdd(big, small);
        reverse(big);
        return big.next;
    }

    private Node coreAdd(Node head1, Node head2) {
        int add = 0;
        Node node1 = head1, node2 = head2;
        while(node2.next != null) {
            int sum = node1.next.val + node2.next.val + add;
            node1.next.val += sum%10;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1.next != null) {
            node1.next.val += add;
            add = 0;
        }
        if (add != 0) {
            node1.next = new Node(add);
        }
        return head1;
    }

    private int reverse(Node node) {
        // node with head return length
        if (node == null || node.next == null) return 0;
        Node pre = null, curr = node.next, next = curr.next;
        int i = 0;
        while (curr != null) {
            i++;
            if (next == null) {
                curr.next = pre;
                break;
            }
            Node tmp = next;
            next.next = curr;
            curr.next = pre;
            pre = curr;
            curr = tmp;
            next = tmp.next;

        }
        node.next = curr;
        return i;
    }

    static class Node {
        int val;
        Node next;
        Node(){}
        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
