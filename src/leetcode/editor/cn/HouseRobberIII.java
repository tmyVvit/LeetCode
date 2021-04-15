package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class HouseRobberIII {

    public static void main(String[] args) {
        HouseRobberIII robber = new HouseRobberIII();
         // 2 | 1 3 | null 4
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node3;
        node1.right = node4;
        System.out.println(robber.rob(root));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        TmpNode res = getMax(root);
        return Math.max(res.in, res.notin);
    }

    private TmpNode getMax(TreeNode node) {
        if (node == null) return new TmpNode(0, 0);
        if (node.left == null && node.right == null) return new TmpNode(node.val, 0);
        TmpNode left = getMax(node.left);
        TmpNode right = getMax(node.right);
        TmpNode res = new TmpNode();
        // 可以选择当前节点偷或不偷两种情况
        res.in = left.notin + right.notin + node.val;
        res.notin = Math.max(left.in, left.notin) + Math.max(right.in, right.notin);
        return res;
    }

}

class TmpNode {
    int in;
    int notin;
    TmpNode(){}
    TmpNode(int in, int notin) {
        this.in = in;
        this.notin = notin;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}