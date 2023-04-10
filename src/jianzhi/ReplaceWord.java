package jianzhi;

import java.util.List;
import java.util.StringJoiner;

public class ReplaceWord {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie0 trie = new Trie0();
        for (String dict : dictionary) {
            trie.insert(dict);
        }

        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder(" ");
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(trie.findShortest(word));
        }
        return sb.toString();
    }

    private static class Trie0 extends Trie {

        public String findShortest(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return word;
                }
                node = node.children[idx];
                if (node.end) {
                    return word.substring(0, i + 1);
                }
            }

            return word;
        }

    }

}
