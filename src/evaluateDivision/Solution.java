package evaluateDivision;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        print(s.calcEquation(of(of("a", "b"), of("b", "c")),
                new double[]{2.0, 3.0},
                of(of("a", "c"), of("b", "a"))));
    }

    static <T> List<T> of(T... ts) {
        List<T> list = new ArrayList<>();
        for (T t : ts) {
            list.add(t);
        }
        return list;
    }

    static void print(double[] ds) {
        for (double d : ds) {
            System.out.printf("%f ", d);
        }
        System.out.println();
    }

    // 使用并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Node> nodeMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            double value = values[i];

            String val0 = equation.get(0);
            String val1 = equation.get(1);

            Node node0 = nodeMap.computeIfAbsent(val0, k -> new Node(val0));
            Node node1 = nodeMap.computeIfAbsent(val1, k -> new Node(val1));

            if (node1.parent == null && node0.parent == null) {
                node0.parent = node0;
                node0.num = 1;
                node0.addChild(node1, value);
            } else if (node1.parent == null) {
                node0.parent.addChild(node1, node0.num * value);
            } else if (node0.parent == null) {
                node1.parent.addChild(node0, node1.num * (1 / value));
            } else {
                if (node0.parent == node1.parent) {
                    continue;
                }
                Node parent0 = node0.parent;
                Node parent1 = node1.parent;

                parent0.addChild(parent1, 1/node1.num * value * node0.num);
                for (Node child : parent1.children) {
                    parent0.addChild(child, child.num * parent1.num);
                }
                parent1.children.clear();

            }


        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);

            Node node0 = nodeMap.get(query.get(0));
            Node node1 = nodeMap.get(query.get(1));

            if (node0 == null || node1 == null) {
                res[i] = -1.0;
            } else {
                if (node0.parent != node1.parent) {
                    res[i] = -1.0;
                } else {
                    res[i] = node1.num / node0.num;
                }
            }

        }
        return res;
    }



    static class Node {
        String val;
        Node parent;
        Set<Node> children = new HashSet<>();
        double num;

        Node(String val) {
            this.val = val;
        }

        Node(String val, Node parent, double num) {
            this.val = val;
            this.parent = parent;
            this.num = num;
        }

        void addChild(Node node, double num) {
            this.children.add(node);
            node.parent = this;
            node.num = num;
        }
    }
}
