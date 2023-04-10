package jianzhi;

public class MagicDictionary0 {
    MagicDictionary0[] children;
    boolean end;

    public MagicDictionary0() {
        children = new MagicDictionary0[26];
        end = false;
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            insert(word);
        }
    }

    private void insert(String word) {
        MagicDictionary0 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new MagicDictionary0();
            }
            node = node.children[ch - 'a'];
        }
        node.end = true;
    }

    public boolean search(String searchWord) {
        return find(searchWord, 0, this, false);
    }

    private boolean find(String word, int pos, MagicDictionary0 node, boolean modified) {
        if (pos >= word.length()) {
            return modified && node.end;
        }
        char ch = word.charAt(pos);
        int idx = ch - 'a';
        MagicDictionary0 next = node.children[idx];
        if (next != null) {
            if (find(word, pos + 1, next, modified)) {
                return true;
            }
        }
        if (!modified) {
            for (int i = 0; i < 26; i++) {
                if (idx == i || node.children[i] == null) {
                    continue;
                }
                if (find(word, pos + 1, node.children[i], true)) {
                    return true;
                }
            }
        }

        return false;
    }

}
