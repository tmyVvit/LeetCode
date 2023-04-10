package jianzhi;

public class WordsMinimumLength {

    public static void main(String[] args) {
        WordsMinimumLength s = new WordsMinimumLength();
        String[] words = new String[]{"time","atime","btime"};
        System.out.println(s.minimumLengthEncoding(words));
    }

    public int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        for (String word : words) {
            len += insertReverse(trie, word);
        }
        return len;
    }

    // 使用前缀树，将 word 倒转过来插入前缀树中
    private int insertReverse(Trie trie, String word) {
        Trie n = trie;
        int depth = 0, len = 0;
        boolean createNew = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            depth++;
            int idx = word.charAt(i) - 'a';
            if (n.children[idx] == null) {
                // 如果有新节点生成，说明这个 word 是新加入的，无法使用之前的
                createNew = true;
                n.children[idx] = new Trie();
            }
            // 在中间节点发现 end == true 的情况，可以去除掉，
            // 因为原本的 word 可以被当前的覆盖
            if (n.children[idx].end) {
                n.children[idx].end = false;
                len -= (depth + 1);
            }
            n = n.children[idx];
        }

        // 只有是新加的节点才需要额外的空间
        if (createNew) {
            n.end = true;
            len += depth;
            return len + 1;
        }
        return 0;
    }

    private static class Trie {
        Trie[] children = new Trie[26];
        boolean end;
    }


}
