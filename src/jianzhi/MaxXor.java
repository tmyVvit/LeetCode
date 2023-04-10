package jianzhi;

// 剑指 Offer II 067. 最大的异或
// https://leetcode.cn/problems/ms70jA/
public class MaxXor {

    // 暴力，超时
    public int findMaximumXOR0(int[] nums) {
        int max = 0;
        for (int num : nums) {
            for (int i : nums) {
                int tmp = num ^ i;
                max = Math.max(max, tmp);
            }
        }
        return max;
    }

    // 使用一个前缀树，对每个数字的二进制格式存储，根节点是从高位开始的
    public int findMaximumXOR1(int[] nums) {
        Trie trie = new Trie();
        int max = 0;
        for (int num : nums) {
            add(trie, num);

            // 此时 0..i 都在前缀树中，找到其与 num 异或的最大值
            // 因为异或运算是可交换的： x = a ^ b  ==> b = x ^ a
            // 我们可以从高到低位枚举 x 的值: a[i] = num ^ x
            // 其中 a[i] 都在前缀树中，对于 num 的每一位，如果是 1，那么我们找前缀树中该位是否存在 0 ，就可以使 x 的该位为 1
            max = Math.max(max, findMaxXor(trie, num));
        }
        return max;
    }

    private void add(Trie trie, int num) {
        Trie curr = trie;
        for (int i = 30; i >= 0; i--) {
            int b = (num >> i) & 1;
            if (curr.children[b] == null) {
                curr.children[b] = new Trie();
            }
            curr = curr.children[b];
        }
    }

    private int findMaxXor(Trie trie, int num) {
        int x = 0;
        Trie curr = trie;
        for (int i = 30; i >= 0; i--) {
            int b = (num >> i) & 1;
            x <<= 1;
            if (b == 0) {
                if (curr.children[1] != null) {
                    curr = curr.children[1];
                    x += 1;
                } else {
                    curr = curr.children[0];
                }
            } else {
                if (curr.children[0] != null) {
                    curr = curr.children[0];
                    x += 1;
                } else {
                    curr = curr.children[1];
                }
            }
        }
        return x;
    }

    private static class Trie {
        Trie[] children = new Trie[2];
    }

}
