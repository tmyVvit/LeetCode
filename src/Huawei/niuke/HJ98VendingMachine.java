package Huawei.niuke;

import java.util.*;

public class HJ98VendingMachine {
    // 初始化商品
    private static final char operatorR = 'r';
    // 投币
    private static final char operatorP = 'p';
    // 购买商品
    private static final char operatorB = 'b';
    // 退币
    private static final char operatorC = 'c';

    private static final char operatorQ = 'q';

    private static final int[] moneyUnit = new int[]{1, 2, 5, 10};

    private final Map<String, Integer> goods;

    private final Map<String, Integer> goodCount;

    private final Map<Integer, Integer> moneyBox;

    private int moneyLeft = 0;

    public HJ98VendingMachine() {
        goods = new HashMap<>();
        goodCount = new HashMap<>();
        moneyBox = new HashMap<>();

        goods.put("A1", 2);
        goods.put("A2", 3);
        goods.put("A3", 4);
        goods.put("A4", 5);
        goods.put("A5", 8);
        goods.put("A6", 6);
    }

    public void operator(String[] ops) {
        for (String op : ops) {

            String[] splits = op.split(" ");
            switch (op.charAt(0)) {
                case operatorR:
                    rOperate(splits[1].split("-"), splits[2].split("-"));
                    break;
                case operatorP:
                    pOperate(Integer.parseInt(splits[1]));
                    break;
                case operatorB:
                    bOperate(splits[1]);
                    break;
                case operatorC:
                    cOperate();
                    break;
                case operatorQ:
                    if (splits.length != 2) {
                        System.out.println("E010:Parameter error");
                        break;
                    }
                    int type = Integer.parseInt(splits[1]);
                    if (type != 1 && type != 0) {
                        System.out.println("E010:Parameter error");
                        break;
                    }


            }


        }

    }

    private void rOperate(String[] g, String[] m) {
        for (int i = 0; i < g.length; i++) {
            String goodName = "A" + (i + 1);
            int count = goodCount.getOrDefault(goodName, 0);
            count += Integer.parseInt(g[i]);
            goodCount.put(goodName, count);
        }

        for (int i = 0; i < m.length; i++) {
            int money = moneyUnit[i];
            int count = moneyBox.getOrDefault(money, 0);
            count += Integer.parseInt(m[i]);
            moneyBox.put(money, count);
        }
        System.out.println("S001:Initialization is successful");
    }

    private void pOperate(int m) {
        if (m != 1 && m != 2 && m != 5 && m != 10) {
            System.out.println("E002:Denomination error");
            return;
        }

        int smallMoney = moneyBox.getOrDefault(1, 0) + moneyBox.getOrDefault(2, 0) * 2;
        if (smallMoney < m) {
            System.out.println("E003:Change is not enough, pay fail");
            return;
        }

        if (allSoldOut()) {
            System.out.println("E005:All the goods sold out");
            return;
        }

        moneyLeft += m;
        moneyBox.put(m, moneyBox.getOrDefault(m, 0) + 1);
        System.out.println("S002:Pay success,balance=" + moneyLeft);
    }

    private void bOperate(String name) {
        if (!goods.containsKey(name)) {
            System.out.println("E006:Goods does not exist");
            return;
        }

        int count = goodCount.getOrDefault(name, 0);
        if (count == 0) {
            System.out.println("E007:The goods sold out");
            return;
        }

        int goodCost = goods.get(name);
        if (goodCost > moneyLeft) {
            System.out.println("E008:Lack of balance");
            return;
        }

        moneyLeft -= goodCost;
        goodCount.put(name, count - 1);
        System.out.println("S003:Buy success,balance=" + moneyLeft);
    }

    private void cOperate() {
        if (moneyLeft == 0) {
            System.out.println("E009:Work failure");
            return;
        }

        int count10 = 0, count5 = 0, count2 = 0, count1 = 0;
        int leftCount10 = moneyBox.get(10);
        int leftCount5 = moneyBox.get(5);
        int leftCount2 = moneyBox.get(2);
        int leftCount1 = moneyBox.get(1);

        int balance = moneyLeft;
        if (balance >= 10 && leftCount10 > 0) {
            count10 = Math.min(leftCount10, balance / 10);
            balance -= count10 * 10;
        }

        if (balance >= 5 && leftCount5 > 0) {
            count5 = Math.min(leftCount5, balance / 5);
            balance -= count5 * 5;
        }

        if (balance >= 2 && leftCount2 > 0) {
            count2 = Math.min(leftCount2, balance / 2);
            balance -= count2 * 2;
        }

        if (balance >= 1 && leftCount1 > 0) {
            count1 = Math.min(leftCount1, balance);
            balance -= count1;
        }

        moneyLeft = 0;
        moneyBox.put(10, leftCount10 - count10);
        moneyBox.put(5, leftCount5 - count5);
        moneyBox.put(2, leftCount2 - count2);
        moneyBox.put(1, leftCount1 - count1);

        System.out.println("1 yuan coin number=" + count1);
        System.out.println("2 yuan coin number=" + count2);
        System.out.println("5 yuan coin number=" + count5);
        System.out.println("10 yuan coin number=" + count10);
    }

    private void qOperate(int type) {
        if (type == 1) {
            System.out.println("1 yuan coin number=" + moneyBox.get(1));
            System.out.println("2 yuan coin number=" + moneyBox.get(2));
            System.out.println("5 yuan coin number=" + moneyBox.get(5));
            System.out.println("10 yuan coin number=" + moneyBox.get(10));
        } else {
            Object[][] objs = new Object[goods.size()][3];
            int i = 0;
            for (Map.Entry<String, Integer> entry : goods.entrySet()) {
                objs[i][0] = entry.getKey();
                objs[i][1] = entry.getValue();
                objs[i][2] = goodCount.getOrDefault(entry.getKey(), 0);
            }

            Arrays.sort(objs, (obj1, obj2) -> {
                int cmp0 = Integer.compare((int) obj2[2], (int) obj1[2]);
                if (cmp0 != 0) {
                    return cmp0;
                }
                return Character.compare(((String) obj1[0]).charAt(1), ((String) obj1[1]).charAt(1));
            });

            for (Object[] obj : objs) {
                System.out.printf("%s %s %s\n", obj[0], obj[1], obj[2]);
            }
        }
    }

    private boolean allSoldOut() {
        for (Map.Entry<String, Integer> entry : goodCount.entrySet()) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            HJ98VendingMachine machine = new HJ98VendingMachine();
            machine.operator(line.split(";"));
        }
    }
}
