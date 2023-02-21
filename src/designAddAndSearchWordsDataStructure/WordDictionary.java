package designAddAndSearchWordsDataStructure;

public class WordDictionary {

    final Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new Node();
            }
            node = node.next[idx];
        }
        node.end = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int idx, Node node) {
        Node curr = node;
        char ch = word.charAt(idx);
        boolean last = idx == word.length() - 1;
        if (ch == '.') {
            for (Node next : curr.next) {
                if (next == null) {
                    continue;
                }
                if (last) {
                    if (next.end) {
                        return true;
                    }
                } else if (search(word, idx + 1, next)) {
                    return true;
                }
            }
            return false;
        } else {
            int nextIdx = ch - 'a';
            if (curr.next[nextIdx] == null) {
                return false;
            }
            curr = curr.next[nextIdx];
            if (last) {
                return curr.end;
            }
            return search(word, idx + 1, curr);
        }
    }


    static class Node {
        Node[] next = new Node[26];
        boolean end;

    }
}
