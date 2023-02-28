package pathSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);

        Solution s = new Solution();
        List<List<Integer>> res = s.pathSumII(root, 2);
        System.out.println(res);
    }
    // 113 path sum ii
    public List<List<Integer>> pathSumII(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfsII(root, 0, targetSum, new ArrayList<>(), res);
        return res;
    }

    private void dfsII(TreeNode node, int sum, int target, List<Integer> values, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum += node.val;
        values.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == target) {
                res.add(new ArrayList<>(values));
            }
        } else {
            dfsII(node.left, sum, target, values, res);
            dfsII(node.right, sum, target, values, res);
        }
        values.remove(values.size() - 1);
    }

    // 437 path sum iii
    private int count3 = 0;
    public int pathSumIII(TreeNode root, int targetSum) {
        dfsIII(root, 0L, targetSum);
        pathSumIII(root.left, targetSum);
        pathSumIII(root.right, targetSum);
        return count3;
    }


    private void dfsIII(TreeNode node, long sum, int target) {
        if (node == null) {
            return;
        }
        sum += node.val;
        if (sum == target) {
            count3++;
        }
        dfsIII(node.left, sum, target);
        dfsIII(node.right, sum, target);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }
    }
}
