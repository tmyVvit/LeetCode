package jianzhi;

import java.util.*;

public class MagicDictionary {
    // 超时了,可以考虑普通的前缀树，然后使用递归和回溯
    Map<Character, MagicDictionary> children;
    boolean end;
    Set<String> words;

    MagicDictionary() {
        children = new HashMap<>();
        words = new HashSet<>();
    }

    public void buildDict(String[] dictionary) {
        for (String dict : dictionary) {
            insert(dict);
        }
    }

    private List<String> similar(String word) {
        List<String> ans = new ArrayList<>();
        char[] ches = word.toCharArray();
        for (int i = 0; i < ches.length; i++) {
            char tmp = ches[i];
            ches[i] = '*';
            ans.add(new String(ches));
            ches[i] = tmp;
        }
        return ans;
    }

    public void insert(String word) {
        List<String> similar = similar(word);
        for (String s : similar) {
            MagicDictionary last = insert0(s);
            last.words.add(word);
        }
    }

    MagicDictionary insert0(String word) {
        MagicDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children.get(ch) == null) {
                node.children.put(ch, new MagicDictionary());
            }
            node = node.children.get(ch);
        }
        node.end = true;
        return node;
    }

    public boolean search(String word) {
        List<String> similar = similar(word);
        for (String s : similar) {
            MagicDictionary t = find(s);
            if (t != null && t.end &&  (!t.words.contains(word) || (t.words.contains(word) && t.words.size() > 1))) {
                return true;
            }
        }
        return false;
    }

    MagicDictionary find(String word) {
        MagicDictionary node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (node.children.get(ch) == null) {
                return null;
            }
            node = node.children.get(ch);
        }
        return node;
    }
}
