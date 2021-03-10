package Ali;

public class BigNumberAdd2 {
    public static void main(String[] args) {
        BigNumberAdd2 add = new BigNumberAdd2();
        BigNumberAdd.Node node1 = add.arrToList(new int[]{1,2,3});
        BigNumberAdd.Node node2 = add.arrToList(new int[]{8,7,7});
        add.print(add.add2(node1, node2));
    }

    public void print(BigNumberAdd.Node node) {
        BigNumberAdd.Node head = node;
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println("null");
    }

    public BigNumberAdd.Node arrToList(int[] arr) {
        BigNumberAdd.Node head = new BigNumberAdd.Node();
        BigNumberAdd.Node tail = head;
        for (int n : arr) {
            BigNumberAdd.Node node = new BigNumberAdd.Node(n);
            tail.next = node;
            tail = node;
        }
        return head.next;
    }


    public BigNumberAdd.Node add2(BigNumberAdd.Node node1, BigNumberAdd.Node node2) {
        if (node1 == null && node2 == null) return node1;
        if (node1 == null) return node2;
        if (node2 == null) return node1;

        BigNumberAdd.Node reverse1 = new BigNumberAdd.Node(0, node1);
        BigNumberAdd.Node reverse2 = new BigNumberAdd.Node(0, node2);
        int len1 = reverse(reverse1);
        int len2 = reverse(reverse2);

        BigNumberAdd.Node big, small;
        big = len1 > len2 ? reverse1 : reverse2;
        small = len1 > len2 ? reverse2 : reverse1;
        coreAdd(big, small);
        reverse(big);
        return big.next;
    }

    private BigNumberAdd.Node coreAdd(BigNumberAdd.Node head1, BigNumberAdd.Node head2) {
        int add = 0;
        BigNumberAdd.Node node1 = head1, node2 = head2;
        while(node2.next != null) {
            int sum = node1.next.val + node2.next.val + add;
            node1.next.val = sum%10;
            add = sum/10;
            node1 = node1.next;
            node2 = node2.next;
        }
        while (node1.next != null) {
            node1.next.val += add;
            node1 = node1.next;
            add = 0;
        }
        if (add != 0) {
            node1.next = new BigNumberAdd.Node(add);
        }
        return head1;
    }

    private int reverse(BigNumberAdd.Node node) {
        // node with head return length
        if (node == null || node.next == null) return 0;
        BigNumberAdd.Node pre = null, curr = node.next, next = curr.next;
        int i = 0;
        while (curr != null) {
            i++;
            if (next == null) {
                curr.next = pre;
                break;
            }
            BigNumberAdd.Node tmp = next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
            next = tmp.next;

        }
        node.next = curr;
        return i;
    }

}
