package jianzhi;

import jianzhi.common.TreeNode;

// 剑指 Offer II 054. 所有大于等于节点的值之和
public class SumInBST {

    public TreeNode convertBST(TreeNode root) {
        postorder(root, 0);
        return root;
    }

    private int postorder(TreeNode node, int pre) {
        if (node == null) {
            return pre;
        }
        int right = postorder(node.right, pre);
        node.val += right;
        return postorder(node.left, node.val);
    }

}
