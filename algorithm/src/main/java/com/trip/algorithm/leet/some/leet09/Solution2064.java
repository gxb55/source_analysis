package com.trip.algorithm.leet.some.leet09;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年09月07日 08:23:00
 * 2064. 分配给商店的最多商品的最小值
 * 给你一个整数 n ，表示有 n 间零售商店。总共有 m 种产品，每种产品的数目用一个下标从 0 开始的整数数组 quantities 表示，其中 quantities[i] 表示第 i 种商品的数目。
 * <p>
 * 你需要将 所有商品 分配到零售商店，并遵守这些规则：
 * <p>
 * 一间商店 至多 只能有 一种商品 ，但一间商店拥有的商品数目可以为 任意 件。
 * 分配后，每间商店都会被分配一定数目的商品（可能为 0 件）。用 x 表示所有商店中分配商品数目的最大值，你希望 x 越小越好。也就是说，你想 最小化 分配给任意商店商品数目的 最大值 。
 * 请你返回最小的可能的 x 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, quantities = [11,6]
 * 输出：3
 * 解释： 一种最优方案为：
 * - 11 件种类为 0 的商品被分配到前 4 间商店，分配数目分别为：2，3，3，3 。
 * - 6 件种类为 1 的商品被分配到另外 2 间商店，分配数目分别为：3，3 。
 * 分配给所有商店的最大商品数目为 max(2, 3, 3, 3, 3, 3) = 3 。
 * 示例 2：
 * <p>
 * 输入：n = 7, quantities = [15,10,10]
 * 输出：5
 * 解释：一种最优方案为：
 * - 15 件种类为 0 的商品被分配到前 3 间商店，分配数目为：5，5，5 。
 * - 10 件种类为 1 的商品被分配到接下来 2 间商店，数目为：5，5 。
 * - 10 件种类为 2 的商品被分配到最后 2 间商店，数目为：5，5 。
 * 分配给所有商店的最大商品数目为 max(5, 5, 5, 5, 5, 5, 5) = 5 。
 * 示例 3：
 * <p>
 * 输入：n = 1, quantities = [100000]
 * 输出：100000
 * 解释：唯一一种最优方案为：
 * - 所有 100000 件商品 0 都分配到唯一的商店中。
 * 分配给所有商店的最大商品数目为 max(100000) = 100000 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == quantities.length
 * 1 <= m <= n <= 105
 * 1 <= quantities[i] <= 105
 * 通过次数4,898提交次数11,246
 */
public class Solution2064 {
    public static void main(String[] args) {
        Solution2064 solution2064 = new Solution2064();
       /* int n = 6;
        int[] quantities = {11, 6};*/
/*
        int n = 26;
        int[] quantities = {24, 18, 12, 6, 3, 24, 5, 19, 10, 20, 2, 18, 27, 3, 13, 22, 11, 16, 19, 13};*/
     /*
        int n = 7;
        int[] quantities = {15, 10, 10};*/

        int n = 99984;
        int[] quantities = {455, 971, 761, 93461, 614, 966, 226, 671, 43, 200, 41, 55, 301, 613, 28, 172, 346, 123, 569, 21780, 815, 226, 65085, 935, 267, 81, 15, 63418, 242, 695, 44949, 920, 245, 120, 69422, 720, 48735, 734, 698, 522, 145, 654, 99, 370, 706, 69740, 685, 810, 47178, 89531, 355, 552, 498, 74716, 44, 864, 78, 98507, 49481, 88, 32744, 128, 533, 313, 932, 950, 48, 713, 603, 677, 237, 23982};

        int i = solution2064.minimizedMaximum3(n, quantities);
        System.out.println(i);
    }

    public int minimizedMaximum3(int n, int[] quantities) {
        int length = quantities.length;
        int l = 1;
        int r = 100000;
        int max = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < length; i++) {
                int quantity = quantities[i];
                int curCount = (quantity + mid - 1) / mid;
                cnt += curCount;
            }
            if (cnt <= n) {
                r = mid - 1;
                max = mid;
            } else {
                l = mid + 1;
            }
        }
        return max;
    }


    public int minimizedMaximum(int n, int[] quantities) {
        if (n <= quantities.length) {
            Arrays.sort(quantities);
            return quantities[n - 1];
        }
        int l = 0;
        int r = 1000000;
        int res = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int len = n;
            int i = 0;
            int quantity = -1;
            int zeroLen = 0;
            int min = Integer.MIN_VALUE;
            for (; i < quantities.length; ) {
                if (n <= 0) {
                    break;
                }
                if (quantity < 0) {
                    quantity = quantities[i];
                }
                if (quantity >= mid) {
                    quantity -= mid;
                    len--;
                    min = Math.max(min, mid);
                } else if (quantity == 0) {
                    min = Math.max(min, quantity);
                    i++;
                    len--;
                    quantity = -1;
                    zeroLen++;
                } else {
                    min = Math.max(min, quantity);
                    i++;
                    len--;
                    quantity = -1;
                }
            }
            if (len == 0 && i == quantities.length) {
                res = Math.min(res, min);
            } else if (len < 0 && (len + zeroLen) >= 0 && i == quantities.length) {
                res = Math.min(res, min);
            }
            if (len >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }


    public int minimizedMaximum1(int n, int[] quantities) {
        int l = 1, r = (int) 1e5;
        int ans = 0;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            int cnt = 0;
            for (int i = 0; i < quantities.length; i++) {
                int num = quantities[i];
                cnt += (num + mid - 1) / mid;
            }
            if (cnt <= n) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

}
