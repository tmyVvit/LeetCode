package implementTriePrefixTree;

import java.util.HashSet;
import java.util.Set;

public class Trie {

    private final Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
       for (int i = 0; i < word.length(); i++) {
           char ch = word.charAt(i);
           int idx = ch - 'a';
           if (node.next[idx] == null) {
               node.next[idx] = new Node();
           }
           node = node.next[idx];
       }
       node.end = true;
    }

    public boolean search(String word) {
        Node node = searchNode(word);
        return node != null && node.end;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    private Node searchNode(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            node = node.next[idx];
            if (node == null) {
                return node;
            }
        }
        return node;
    }

    public static class Node {
        Node[] next = new Node[26];
        boolean end;
    }

}
