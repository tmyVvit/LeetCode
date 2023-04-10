package jianzhi;

// 剑指 Offer II 066. 单词之和
// https://leetcode.cn/problems/z1R5dt/?favorite=e8X3pBZi
public class MapSum {

    Trie trie = new Trie();

    /** Initialize your data structure here. */
    public MapSum() {

    }

    public void insert(String key, int val) {
        Trie node = trie;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
        }
        node.val = val;
    }

    public int sum(String prefix) {
        Trie node = trie;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }
        return sum(node);
    }

    private int sum(Trie trie) {
        if (trie == null) {
            return 0;
        }
        int sum = trie.val;
        for (Trie child : trie.children) {
            sum += sum(child);
        }
        return sum;
    }

    private static class Trie {
        Trie[] children = new Trie[26];
        int val;
    }
}
