package ReverseWordsInAStringIII;

// 557. Reverse Words in a String III

// Given a string, you need to reverse the order of characters in each word within a sentence
// while still preserving whitespace and initial word order.
public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverseWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseWord(String s) {
        String tmp = s.trim();
        StringBuilder sb = new StringBuilder();
        for (int i = tmp.length() - 1; i >= 0; i--) {
            sb.append(tmp.charAt(i));
        }
        return sb.toString();
    }
}
