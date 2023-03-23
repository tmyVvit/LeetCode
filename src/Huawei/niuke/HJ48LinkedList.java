package Huawei.niuke;

import java.util.Scanner;

public class HJ48LinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int count = sc.nextInt();

            Node head = new Node();
            head.next = new Node(sc.nextInt());

            for (int i = 1; i < count; i++) {
                Node node = new Node(sc.nextInt());
                int pre = sc.nextInt();
                add(head, node, pre);
            }

            delete(head, sc.nextInt());
            Node node = head.next;
            while (node != null) {
                System.out.print(node.val);
                System.out.print(" ");
                node = node.next;
            }
            System.out.println();
        }
    }

    private static void delete(Node head, int val) {
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                Node delete = tmp.next;
                tmp.next = delete.next;
                delete.next = null;
                break;
            } else {
                tmp = tmp.next;
            }
        }

    }

    private static void add(Node head, Node node, int pre) {
        Node tmp = head.next;
        while (tmp != null) {
            if (tmp.val == pre) {
                node.next = tmp.next;
                tmp.next = node;
                break;
            } else {
                tmp = tmp.next;
            }
        }
    }

    public static class Node {
        int val;
        Node next;

        Node(){}

        Node(int val) {
            this.val = val;
        }
    }

}
