package Huawei.niuke;

import java.util.Scanner;

public class HJ18FindValidIP {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a = 0,b = 0, c = 0, d = 0, e = 0, invalid = 0, pri = 0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String[] line = in.nextLine().split("~");
            String ip = line[0];
            String mask = line[1];

            int[] ip0 = validIP(ip);
            if (ip0 == null) {
                invalid++;
                continue;
            }

            if (ip0[0] == 0 || ip0[0] == 127) {
                continue;
            }

            int[] mask0 = validMask(mask);

            if (mask0 == null) {
                invalid++;
                continue;
            }

            if (ip0[0] >= 1 && ip0[0] <= 126) {
                a++;
            } else if (ip0[0] >= 128 && ip0[0] <= 191) {
                b++;
            } else if (ip0[0] >= 192 && ip0[0] <= 223) {
                c++;
            } else if (ip0[0] >= 224 && ip0[0] <= 239) {
                d++;
            } else if (ip0[0] >= 240 && ip0[0] <= 255) {
                e++;
            }

            if (ip0[0] == 10) {
                pri++;
            } else if (ip0[0] == 172 && ip0[1] >= 16 && ip0[1] <= 31) {
                pri++;
            } else if (ip0[0] == 192 && ip0[1] == 168) {
                pri++;
            }
        }

        System.out.printf("%d %d %d %d %d %d %d\n", a, b, c, d, e, invalid, pri);
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

        if ((nums[0] == 255 && nums[1] == 255 && nums[2] == 255 && nums[3] == 255)
                ||(nums[0] == 0 && nums[1] == 0 && nums[2] == 0 && nums[3] == 0)) {
            return null;
        }

        if (!isPrefixAllOne(nums)) {
            return null;
        }

        return nums;
    }

    private static boolean isPrefixAllOne(int[] nums) {
        boolean startZero = false;

        for (int num : nums) {
            if (startZero) {
                if (!(num == 0)) {
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
