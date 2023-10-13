package a_daily.d_20231011;

import java.util.*;

public class RewardTopKStudents {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {

        Set<String> positives = new HashSet<>(Arrays.asList(positive_feedback));

        Set<String> negatives = new HashSet<>(Arrays.asList(negative_feedback));

        PriorityQueue<Node> q = new PriorityQueue<>(k);
        for (int i = 0; i < report.length; i++) {
            String line = report[i];
            String[] words = line.split(" ");
            int score = 0;
            for (String word : words) {
                if (positives.contains(word)) {
                    score += 3;
                } else if (negatives.contains(word)) {
                    score -= 1;
                }
            }

            Node node = new Node(student_id[i], score);
            if (q.size() < k) {
                q.offer(node);
            } else {
                Node min = q.peek();
                if (score > min.score || (score == min.score && node.id < min.id)) {
                    q.poll();
                    q.offer(node);
                }
            }
        }

        int[] result = new int[k];
        int i = k - 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            result[i--] = node.id;
        }
        List<Integer> list = new ArrayList<>();
        for (int r : result) {
            list.add(r);
        }
        return list;
    }

    static class Node implements Comparable<Node> {
        int score;
        int id;

        Node(int id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int hashCode() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Node) {
                Node node = (Node) o;
                return id == node.id;
            }
            return false;
        }

        @Override
        public int compareTo(Node node) {
            return score == node.score ? node.id - id : score - node.score;
        }

    }
}
