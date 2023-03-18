package jianzhi;

import jianzhi.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInBinaryTree {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return null;
        }

        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        List<Integer> res = new ArrayList<>();

        while (!level.isEmpty()) {
            List<TreeNode> current = level;
            level = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            for (TreeNode node : current) {
                max = Math.max(max, node.val);
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }

            res.add(max);
        }
        return res;
    }
}
