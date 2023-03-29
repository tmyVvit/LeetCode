package Huawei.niuke;

import java.util.Scanner;

public class HJ39SameIP {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String maskStr = sc.next();
            String ipStr0 = sc.next();
            String ipStr1 = sc.next();

            int[] mask = validMask(maskStr);
            if (mask == null) {
                System.out.println(1);
                continue;
            }

            int[] ip0 = validIP(ipStr0);
            if (ip0 == null) {
                System.out.println(1);
                continue;
            }

            int[] ip1 = validIP(ipStr1);
            if (ip1 == null) {
                System.out.println(1);
                continue;
            }

            boolean same = true;
            for (int i = 0; i < 4; i++) {
                if ((ip0[i] & mask[i]) != (ip1[i] & mask[i])) {
                    same = false;
                    break;
                }
            }

            System.out.println(same ? 0 : 2);
        }

    }

    private static int[] validIP(String ip) {
        if (ip == null) {
            return null;
        }
        String[] ips = ip.split("\\.");
        if (ips.length != 4) {
            return null;
        }

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                int num = Integer.parseInt(ips[i]);
                if (num >= 0 && num <= 255) {
                    nums[i] = num;
                } else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }
        return nums;
    }

    private static int[] validMask(String mask) {
        if (mask == null) {
            return null;
        }
        String[] masks = mask.split("\\.");
        if (masks.length != 4) {
            return null;
        }

        int[] nums = new int[4];
        for (int i = 0; i < 4; i++) {
            try {
                int num = Integer.parseInt(masks[i]);
                if (num >= 0 && num <= 255) {
                    nums[i] = num;
                } else {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
        }

        if (!isPrefixAllOne(nums)) {
            return null;
        }

        return nums;
    }

    private static boolean isPrefixAllOne(int[] nums) {
        boolean startZero = false;

        for (int num : nums) {
            if (num < 0 || num > 255) {
                return false;
            }

            if (startZero) {
                if (num != 0) {
                    return false;
                }
            } else {
                if (num == 255) {
                    continue;
                }
                if (num == 0) {
                    startZero = true;
                    continue;
                }
                int n = 255;
                while (n > 0) {
                    if (num == n) {
                        startZero = true;
                        break;
                    }
                    n = (n << 1) & 255;
                }

                if (!startZero) {
                    return false;
                }
            }
        }

        return true;
    }
}
