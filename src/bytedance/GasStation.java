package bytedance;

// - 1、通勤车油耗（该题目为算法题，是在和面试官聊之前做的，上机形式）
// - 字节跳动在北京有 N 个工区，形成一个环状，Bytebus 是往返在各个工区的通勤车，按工区的顺序行驶，其中第 i 个工区有汽油 gas[i] 升。
//  你有一辆油箱容量无限的 Bytebus，从 第 i 个工区开往第 i+1 个工区需要消耗汽油 cost[i] 升。
//  你从其中的一个工区出发，开始 时油箱为空，可以使用当前工区的汽油 gas[i]升。
//  如果你可以绕环路行驶一周，则返回出发 时工区的编号，否则返回 -1。
//  - 输入：gas = [1,2,3,4,5]
//        cost = [3,4,5,1,2]
//  - 输出：3
public class GasStation {

    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(gasStation.byteBus(gas, cost));
    }

    public int byteBus(int[] gas, int[] cost) {
        // totalGas 总的剩余油量， currentGas 从开始到现在车内剩余油量
        int totalGas, currentGas;
        int start = 0;
        currentGas = totalGas = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            // 当currentGas < 0时，说明前一个start无法绕一圈，以i+1为开始继续
            if (currentGas < 0) {
                start = i + 1;
                currentGas = 0;
            }
        }
        // 如果剩余油量>=0，则必然有解
        if (totalGas < 0) {
            return -1;
        }
        return start;
    }

    public int byteBus2(int[] gas, int[] cost) {
        // 遍历
        for (int i = 0; i < gas.length; i++) {
            int j = i;
            int gasLeft = 0;
            for (int k = 0; k < gas.length; k++) {
                gasLeft += gas[j] - cost[j];
                if (gasLeft < 0) {
                    break;
                }
                j = (j + 1) % gas.length;
                // 已经成功绕了一圈
                if (i == j) return i;
            }
            // j 绕到了 i 之前并且失败了
            // i 之前已经遍历过了不可能成功
            if (j < i) return -1;
        }
        return -1;
    }
}
