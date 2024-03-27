package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/3/27 11:24
 */
public class Solution2580 {
    public static void main(String[] args) {
        Solution2580 solution2580 = new Solution2580();
        //int[][] ranges = {{1, 3}, {10, 20}, {2, 5}, {4, 8}};
      //  int[][] ranges = {{34,56},{28,29},{12,16},{11,48},{28,54},{22,55},{28,41},{41,44}};
        int[][] ranges = {{57,92},{139,210},{306,345},{411,442},{533,589},{672,676},{801,831},{937,940},{996,1052},{1113,1156},{1214,1258},{1440,1441},{1507,1529},{1613,1659},{1773,1814},{1826,1859},{2002,2019},{2117,2173},{2223,2296},{2335,2348},{2429,2532},{2640,2644},{2669,2676},{2786,2885},{2923,2942},{3035,3102},{3177,3249},{3310,3339},{3450,3454},{3587,3620},{3725,3744},{3847,3858},{3901,3993},{4100,4112},{4206,4217},{4250,4289},{4374,4446},{4510,4591},{4675,4706},{4732,4768},{4905,4906},{5005,5073},{5133,5142},{5245,5309},{5352,5377},{5460,5517},{5569,5602},{5740,5791},{5823,5888},{6036,6042},{6096,6114},{6217,6262},{6374,6394},{6420,6511},{6564,6587},{6742,6743},{6797,6877},{6909,6985},{7042,7117},{7141,7144},{7276,7323},{7400,7456},{7505,7557},{7690,7720},{7787,7800},{7870,7880},{8013,8031},{8114,8224},{8272,8328},{8418,8435},{8493,8537},{8600,8704},{8766,8812},{8839,8853},{9032,9036},{9108,9189},{9222,9291},{9344,9361},{9448,9502},{9615,9673},{9690,9800},{9837,9868},{85,96},{145,202},{254,304},{372,411},{534,551},{629,692},{727,787},{861,944},{1041,1084},{1133,1174},{1260,1307},{1339,1358},{1478,1548},{1580,1618},{1694,1814},{1848,1891},{1936,1990},{2058,2130}};
        int i = solution2580.countWays1(ranges);
        System.out.println(i);
    }

    public int countWays(int[][] ranges) {
        List<int[]> list = new ArrayList<>();
        for (int[] arr : ranges) {
            int l = arr[0];
            int r = arr[1];
            if (list.isEmpty()) {
                list.add(new int[]{l, r});
                continue;
            }
            boolean flag = false;
            for (int i = 0; i < list.size(); i++) {
                int[] ints = list.get(i);
                int l1 = ints[0];
                int r1 = ints[1];
                if (r < l1 || l > r1) {

                } else {
                    ints[0] = Math.min(l, l1);
                    ints[1] = Math.max(r, r1);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(new int[]{l, r});
            }
        }
        // System.out.println(list.size());
        long cur = 1;
        for (int i = 0; i < list.size(); i++) {
            cur = cur * 2;
            cur = cur % 100000007;
        }
        return 0;
    }

    public int countWays1(int[][] ranges) {
        Arrays.sort(ranges, (x, y) -> x[0] - y[0]);
        List<int[]> list = new ArrayList<>();
        int last = -1;
        for (int[] arr : ranges) {
            int l = arr[0];
            int r = arr[1];
            if (last == -1) {
                list.add(new int[]{l, r});
                last = r;
            } else if (l > last) {
                list.add(new int[]{l, r});
                last=r;
            } else if (l <= last) {
                list.get(list.size() - 1)[1] = Math.max(r, list.get(list.size() - 1)[1]);
                last=Math.max(r, list.get(list.size() - 1)[1]);
            }
        }
        int cur = 1;
        for (int i = 0; i < list.size(); i++) {
            cur = cur * 2;
            cur = cur % 1000000007;
        }
        return  cur;
    }
}
