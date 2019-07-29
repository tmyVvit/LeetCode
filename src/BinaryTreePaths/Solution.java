package BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

// 257. Binary Tree Paths
// return all paths from root to leafs

//  using a simple heap to find all paths
public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new ArrayList<>();
        if (root == null) return allPaths;
        if (isLeaf(root)) {
            allPaths.add(String.valueOf(root.val));
            return allPaths;
        }
        int flag = 0;//root.left != null ? 1 : 2;
        Heap heap = new Heap();
        heap.push(root, flag);
        HeapNode heapNode;
        while (heap.length > 0 && (heapNode = heap.pop()) != null) {
            if (heapNode.flag == 0) {
                if (isLeaf(heapNode.node)) {
                    allPaths.add(getPath(heap, heapNode));
                    continue;
                }
                if (heapNode.node.left != null) {
                    heap.push(heapNode.node, 1);
                    heap.push(heapNode.node.left, 0);
                    continue;
                }
                if (heapNode.node.right != null) {
                    heap.push(heapNode.node, 2);
                    heap.push(heapNode.node.right, 0);
                }
            } else if (heapNode.flag == 1) {
                if (heapNode.node.right != null) {
                    heap.push(heapNode.node, 2);
                    heap.push(heapNode.node.right, 0);
                }
            }
        }
        return allPaths;
    }

    private String getPath(Heap heap, HeapNode heapNode) {
        HeapNode[] nodes = heap.getNodes();
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < heap.length; i++) {
            path.append(nodes[i].node.val).append("->");
        }
        path.append(heapNode.node.val);
        return path.toString();
    }

    private boolean isLeaf(TreeNode treeNode) {
        return treeNode.left == null && treeNode.right == null;
    }

    class Heap {
        int capacity = 10;
        int length;
        HeapNode[] nodes;

        Heap() {
            nodes = new HeapNode[capacity];
            length = 0;
        }

        private void reload() {
            if (length == capacity) {
                capacity *= 2;
                HeapNode[] newNodes = new HeapNode[capacity];
                System.arraycopy(nodes, 0, newNodes, 0, nodes.length);
                nodes = newNodes;
            }
        }

        void push(HeapNode heapNode) {
            nodes[length++] = heapNode;
            reload();
        }

        void push(TreeNode node, int flag) {
            push(new HeapNode(node, flag));
        }

        HeapNode pop() {
            if (length == 0) return null;
            return nodes[--length];
        }

        HeapNode[] getNodes() {
            return nodes;
        }
    }

    class HeapNode {
        TreeNode node;
        int flag;

        HeapNode(TreeNode node, int flag) {
            this.flag = flag;
            this.node = node;
        }
    }
}

