package com.trip.algorithm.leet.some.leet2209;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年09月04日 22:06:00
 *
 *
 *
 *
 * 类似的题目还有：
 *
 * 452. 用最少数量的箭引爆气球
 *
 * 435. 无重叠区间
 *
 * 不能贪心，只能DP的问题有：
 *
 * 2008. 出租车的最大盈利
 *
 * 1235. 规划兼职工作
 *
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 * 通过次数57,585提交次数93,260
 */
public class Solution646 {
    public static void main(String[] args) {
        Solution646 solution646 = new Solution646();
        int[][] arr = {{1, 2}, {1, 3}, {2, 6}, {5, 6}, {3, 4}};
        // int[][] arr = {{7, 9}, {4, 5}, {7, 9}, {-7, -1}, {0, 10}, {3, 10}, {3, 6}, {2, 3}};

        int longestChain = solution646.findLongestChain(arr);
        System.out.println(longestChain);
    }

    public int findLongestChain(int[][] pairs) {
        List<int[]> collect = Arrays.stream(pairs).sorted(Comparator.comparingInt(x -> x[0])).collect(Collectors.toList());
        int res = 0;
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < collect.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (collect.get(i)[0] > collect.get(j)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    private int process(int[] ints, int i, List<int[]> collect, Map<int[], Map<Integer, Integer>> map) {
        if (i == collect.size()) {
            return 0;
        }
        if (map.containsKey(ints)) {
            Map<Integer, Integer> map1 = map.get(ints);
            boolean b = map1.containsKey(i);
            if (b) {
                return map1.get(i);
            }
        }
        int p1 = process(ints, i + 1, collect, map);
        int p2 = 0;
        if (ints[1] < collect.get(i)[0]) {
            p2 = process(collect.get(i), i + 1, collect, map) + 1;
        }
        return Math.max(p1, p2);
    }
}
