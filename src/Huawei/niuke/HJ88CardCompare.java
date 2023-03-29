package Huawei.niuke;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ88CardCompare {

    private static final Map<String, Integer> map = new HashMap<>();

    static {
        map.put("3", 0);
        map.put("4", 1);
        map.put("5", 2);
        map.put("6", 3);
        map.put("7", 4);
        map.put("8", 5);
        map.put("9", 6);
        map.put("10", 7);
        map.put("J", 8);
        map.put("Q", 9);
        map.put("K", 10);
        map.put("A", 11);
        map.put("2", 12);
        map.put("joker", 13);
        map.put("JOKER", 14);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] cards = sc.nextLine().split("-");

            if (isTwoJoker(cards[0])) {
                System.out.println(cards[0]);
                continue;
            } else if (isTwoJoker(cards[1])) {
                System.out.println(cards[1]);
                continue;
            }

            String[] card0 = cards[0].split(" ");
            String[] card1 = cards[1].split(" ");

            if (card0.length != card1.length) {
                if (card0.length == 4) {
                    System.out.println(cards[0]);
                } else if (card1.length == 4) {
                    System.out.println(cards[1]);
                } else {
                    System.out.println("ERROR");
                }
                continue;
            }

            int cmp = compare(card0[0], card1[0]);
            if (cmp < 0) {
                System.out.println(cards[1]);
            } else {
                System.out.println(cards[0]);
            }
        }
    }

    private static boolean isTwoJoker(String a) {
        return "joker JOKER".equals(a) || "JOKER joker".equals(a);
    }


    private static int compare(String a, String b) {
        return map.get(a) - map.get(b);
    }

}
