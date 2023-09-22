package a_daily.d_20230921;

import common.Pair;
import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/maximum-width-of-binary-tree/
public class MaxWidthOfBinaryTree {

    public static void main(String[] args) {
        MaxWidthOfBinaryTree s = new MaxWidthOfBinaryTree();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(s.widthOfBinaryTree(root));
    }
    private boolean emptyNode(TreeNode node) {
        return node == null || (node.left == null && node.right == null);
    }

    // 广度优先遍历
    public int widthOfBinaryTree(TreeNode root) {
        List<Pair<Integer, TreeNode>> list = new ArrayList<>();
        list.add(new Pair<>(1, root));
        int max = 0;
        while (!list.isEmpty()) {
            List<Pair<Integer, TreeNode>> tmp = list;;
            list = new ArrayList<>();
            if (tmp.size() == 1) {
                max = Math.max(max, 1);
            } else {
                max = Math.max(max, tmp.get(tmp.size()-1).left - tmp.get(0).left + 1);
            }
            for (Pair<Integer, TreeNode> p : tmp) {
                TreeNode n = p.right;
                int idx = p.left;
                if (n.left != null) {
                    list.add(new Pair<>(idx << 1, n.left));
                }
                if (n.right != null) {
                    list.add(new Pair<>(((idx << 1) | 1), n.right));
                }
            }
        }
        return max;
    }

    // 超出内存限制
    public int widthOfBinaryTree0(TreeNode root) {
        // write code here
        TreeNode p = new TreeNode(0);
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        int max = 1;
        while (!list.isEmpty()) {
            List<TreeNode> tmp = list;
            list = new ArrayList<>();
            max = Math.max(max, tmp.size());
            int l = 0, r = tmp.size()-1;
            while (l <= r && emptyNode(tmp.get(l))) {
                l++;
            }
            while (l <= r && emptyNode(tmp.get(r))) {
                r--;
            }
            boolean findLeft = false;
            for (int i = l; i < r; i++) {
                if (tmp.get(i) == null) {
                    list.add(null);
                    list.add(null);
                    continue;
                }
                if (findLeft) {
                    list.add(tmp.get(i).left);
                    list.add(tmp.get(i).right);
                } else {
                    if (tmp.get(i).left != null) {
                        list.add(tmp.get(i).left);
                        findLeft = true;
                    }
                    if (findLeft || tmp.get(i).right != null) {
                        list.add(tmp.get(i).right);
                        findLeft = true;
                    }
                }
            }
            TreeNode left = tmp.get(r).left;
            TreeNode right = tmp.get(r).right;
            if (right != null) {
                if (findLeft || left != null) {
                    list.add(left);
                }
                list.add(right);
            } else if (left != null) {
                list.add(left);
            }
        }
        return max;
    }
}
