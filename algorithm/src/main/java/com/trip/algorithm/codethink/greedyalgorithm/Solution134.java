package com.trip.algorithm.codethink.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/2/20 19:29
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * 示例 2:
 * <p>
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class Solution134 {
    public static void main(String[] args) {
        // int[] gas = {2, 3, 4}, cost = {3, 4, 3};
        //int[] gas = {1,2,3,4,5}, cost = {3,4,5,1,2};
        // int[] gas = {5, 1, 2, 3, 4}, cost = {4, 4, 1, 5, 1};
        int[] gas = {67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66
        }, cost = {27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26
        };

        int i = Solution134.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = cost.length;
        int[] cur = new int[length];
        int[] sumArr = new int[length];
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            cur[i] = gas[i] - cost[i];
            sum += cur[i];
            if (cur[i] >= 0) {
                list.add(i);
            }
            if (i == 0) {
                sumArr[i] = cur[i];
            } else {
                if ((cur[i] + sumArr[i - 1]) >= 0) {
                    sumArr[i] = cur[i] + sumArr[i - 1];
                }
            }
        }
        if (sum < 0) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            int sum1 = 0;
            int count1 = 0;
            for (int j = integer; j < length && sum1 >= 0; j++) {
                sum1 += cur[j];
                count1++;
            }
            for (int j = 0; j < integer && sum1 >= 0; j++) {
                sum1 += cur[j];
                count1++;
            }
            if (count1 == length) {
                return integer;
            }
        }
        return -1;
    }
}
