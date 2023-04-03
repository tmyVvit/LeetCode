package mianshi202303.xiaomi;

import common.TreeNode;

import java.util.LinkedList;

public class BfsTree {

    public void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addFirst(root);

        while (!list.isEmpty()) {
            TreeNode node = list.pollFirst();

            // do
            System.out.print(node.val);
            System.out.print(" ");

            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
        }

    }
}
