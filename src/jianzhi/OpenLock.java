package jianzhi;

import java.util.*;

public class OpenLock {

    public static void main(String[] args) {
        OpenLock ol = new OpenLock();
        String[] ends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        System.out.println(ol.openLock(ends, target));

    }

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));

        List<String> current = new ArrayList<>();
        current.add("0000");
        if (visited.contains("0000")) {
            return -1;
        }
        visited.add("0000");
        int step = -1;
        while (!current.isEmpty()) {

            List<String> level = current;
            current = new ArrayList<>();
            step++;
            for (String s : level) {
                if (target.equals(s)) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    char[] ches = s.toCharArray();
                    char tmp = ches[i];
                    ches[i] = add(tmp);
                    String next1 = new String(ches);
                    if (!visited.contains(next1)) {
                        visited.add(next1);
                        current.add(next1);
                    }

                    ches[i] = minus(tmp);
                    String next2 = new String(ches);
                    if (!visited.contains(next2)) {
                        visited.add(next2);
                        current.add(next2);
                    }
                }
            }
        }

        return -1;

    }

    private char add(char ch) {
        if (ch < '9') {
            return (char) (ch + 1);
        }
        return '0';
    }

    private char minus(char ch) {
        if (ch == '0') {
            return '9';
        }
        return (char) (ch - 1);
    }
}
