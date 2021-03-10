package Huawei;

import java.util.Scanner;

//2.3,3,5.6,7,6;
//11,3,8.6,25,1;
//0.3,9,5.3,66,7.8;
//1,3,2,7,5;
//340,670,80.6;
//<=,<=,<=
public class Test1 {
    public static void main(String[] args) {
        String[] pars;
        int opNum, parNum;
        try (Scanner sc = new Scanner(System.in)) {
            String line = sc.nextLine();
            pars = line.split(";");
        }
        // 不等式符号
        String[] operators = pars[pars.length-1].split(",");
        opNum = operators.length;
        // 目标值
        double[] targets = new double[operators.length];
        String[] targetsStr = pars[pars.length - 2].split(",");
        for (int i = 0; i < opNum; i++) {
            targets[i] = Double.parseDouble(targetsStr[i]);
        }
        // 不等式变量
        String[] xStr = pars[pars.length-3].split(",");
        parNum = xStr.length;
        int[] xs = new int[parNum];
        for (int i = 0; i < parNum; i++) {
            xs[i] = Integer.parseInt(xStr[i]);
        }
        //系数
        double[][] a = new double[opNum][parNum];
        for (int i = 0; i < opNum; i++) {
            String[] currAs = pars[i].split(",");
            for (int j = 0; j < parNum; j++) {
                a[i][j] = Double.parseDouble(currAs[j]);
            }

        }

        int max = Integer.MIN_VALUE;
        boolean success = true;
        for (int i = 0; i < opNum; i++) {
            double res = 0;
            for (int j = 0; j < parNum; j++) {
                res += a[i][j] * xs[j];
            }
            if (res == targets[i]) {
                if(!operators[i].contains("=")) {
                    success = false;
                }
                max = Math.max(0, max);
            } else if (res > targets[i]) {
                if (!operators[i].contains(">")) success = false;
                max = Math.max(max, (int) (res-targets[i]));
            } else {
                if (!operators[i].contains("<")) success = false;
                max = Math.max(max, (int) (targets[i] - res));
            }
        }
        System.out.println(success ? success : success+ " " + max);
    }
}
