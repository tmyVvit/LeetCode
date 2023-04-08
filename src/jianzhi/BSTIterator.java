package jianzhi;

import jianzhi.common.TreeNode;

import java.util.LinkedList;

public class BSTIterator {
    private final LinkedList<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new LinkedList<>();
        initStack(root);
    }

    private void initStack(TreeNode node) {
        if (node == null) {
            return;
        }
        initStack(node.right);
        stack.addLast(node);
        initStack(node.left);
    }

    public int next() {
        if (hasNext()) {
            return stack.pollLast().val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
