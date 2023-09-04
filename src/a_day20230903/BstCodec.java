package a_day20230903;

import common.TreeNode;

import java.util.Base64;


public class BstCodec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(0);
        root.right.left = new TreeNode(4);

        String ori = printTreeNode(root);
        System.out.println(ori.length() + ":" + ori);
        BstCodec codec = new BstCodec();
        byte[] bytes = codec.write(root);
        System.out.println(bytes.length + ":" + Base64.getEncoder().encodeToString(bytes));
        TreeNode node = codec.read(bytes, 0);
        System.out.println(printTreeNode(node));
    }

    public static String printTreeNode(TreeNode root) {
        if (root == null) {
            return "null";
        }
        return root.val + "(" + printTreeNode(root.left) + "," + printTreeNode(root.right) + ")";
    }



    private byte[] write(TreeNode node) {
        if (node == null) {
            return new byte[]{(byte) 0xFF};
        }

        byte[] left = write(node.left);
        byte[] right = write(node.right);
        byte[] val = intToByte(node.val);
        int len = 4 + val.length + left.length + right.length;
        byte[] res = new byte[len];
        System.arraycopy(intToByte(len), 0, res, 0, 4);
        System.arraycopy(val, 0, res,4, val.length);
        System.arraycopy(left, 0, res, 4 + val.length, left.length);
        System.arraycopy(right, 0, res, 4 + val.length + left.length, right.length);
        return res;
    }

    private byte[] intToByte(int val) {
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (val >> 24);
        bytes[1] = (byte) (val >> 16);
        bytes[2] = (byte) (val >> 8);
        bytes[3] = (byte) val;
        return bytes;
    }

    private int readInt(byte[] bytes, int offset) {
        return (bytes[offset] << 24) | (bytes[offset + 1] << 16) | (bytes[offset + 2] << 8) | bytes[offset + 3];
    }


    private TreeNode read(byte[] bytes, int offset) {
        if (bytes[offset] == (byte) 0xFF) {
            return null;
        }
        int val = readInt(bytes, offset + 4);
        TreeNode node = new TreeNode(val);
        int leftLen = readLen(bytes, offset + 8);
        node.left = read(bytes, offset + 8);
        node.right = read(bytes, offset + 8 + leftLen);
        return node;
    }

    private int readLen(byte[] bytes, int offset) {
        if (bytes[offset] == (byte) 0xFF) {
            return 1;
        }
        return readInt(bytes, offset);
    }

}
