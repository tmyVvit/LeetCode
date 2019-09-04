package Huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


// 华为在线笔试题
// 实现一个极简解释器，给定n(n<100) 行脚本代码，解释器从第一行往下依次解释执行，直到最后一句
// 被解释代码只存在变量名，等于号（=）， 加号（+），空格，不存在其他任何符号，变量名中间不能有空格，
// 数字为32位内整数，其他不限，用例语法保证正确
public class Huawei2 {
    private static Map<String, ExpressionNode> variablePool = new HashMap<>();
    private static Map<String, Integer> certainVariable = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(simpleInterpreter());
    }

    public static String simpleInterpreter() {
        try (Scanner sc = new Scanner(System.in)) {
            int lines = sc.nextInt();
            sc.nextLine();
            String result = null;
            for (; lines > 0; lines--) {
                result = calculateEachExpression(sc.nextLine());
            }
            return result;
        }
    }

    private static String calculateEachExpression(String expression) {
        if (expression == null || !expression.contains("=")) return "NA";
        expression = expression.trim().replaceAll("[ \r\n]", "");
        String[] nameAndValue = expression.split("=");
        if (nameAndValue.length < 2) return "NA";
        String name = nameAndValue[0];
        int value = 0;
        StringBuilder newExpression = new StringBuilder(name + "=");
        boolean calculated = true;
        for (int i = 1; i < nameAndValue.length; i++) {
            String[] variables = nameAndValue[i].split("\\+");
            for (String variable : variables) {
                if (isNumber(variable)) {
                    value += Integer.parseInt(variable);
                } else if (certainVariable.containsKey(variable)) {
                    value += certainVariable.get(variable);
                } else {
                    calculated = false;
                    newExpression.append(variable).append("\\+");
                }
            }
        }
        if (calculated) {
            certainVariable.put(name, value);
            variablePool.remove(name);
            calculateVariablePool(name, value);
            return String.valueOf(value);
        } else {
            newExpression.append(value);
            ExpressionNode expressionNode;
            if (variablePool.containsKey(name)) {
                expressionNode = variablePool.get(name);
                expressionNode.setExpression(newExpression.toString());
            } else expressionNode = new ExpressionNode(name, newExpression.toString());
            variablePool.put(name, expressionNode);
            return "NA";
        }
    }

    private static void calculateVariablePool(String newName, int newValue) {
        if (variablePool.isEmpty()) return;
        for (String name : variablePool.keySet()) {
            ExpressionNode node = variablePool.get(name);
            if (node.getExpression().contains(newName)) {
                calculateEachExpression(node.getExpression());
            }
        }
    }

    private static boolean isNumber(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    static class ExpressionNode {
        private String name;
        private String expression;

        ExpressionNode(String name, String expression) {
            this.name = name;
            this.expression = expression;
        }

        String getExpression() {
            return expression;
        }

        void setExpression(String expression) {
            this.expression = expression;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
