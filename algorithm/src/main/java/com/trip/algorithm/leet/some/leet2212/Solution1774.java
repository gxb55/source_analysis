package com.trip.algorithm.leet.some.leet2212;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年12月04日 09:39:00
 * 1774. 最接近目标价格的甜点成本
 * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 * <p>
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 * 给你以下三个输入：
 * <p>
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 * <p>
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * 输出：10
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 7
 * - 选择 1 份 0 号配料：成本 1 x 3 = 3
 * - 选择 0 份 1 号配料：成本 0 x 4 = 0
 * 总成本：7 + 3 + 0 = 10 。
 * 示例 2：
 * <p>
 * 输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
 * 输出：17
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 3
 * - 选择 1 份 0 号配料：成本 1 x 4 = 4
 * - 选择 2 份 1 号配料：成本 2 x 5 = 10
 * - 选择 0 份 2 号配料：成本 0 x 100 = 0
 * 总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
 * 示例 3：
 * <p>
 * 输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
 * 输出：8
 * 解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
 * 示例 4：
 * <p>
 * 输入：baseCosts = [10], toppingCosts = [1], target = 1
 * 输出：10
 * 解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == baseCosts.length
 * m == toppingCosts.length
 * 1 <= n, m <= 10
 * 1 <= baseCosts[i], toppingCosts[i] <= 104
 * 1 <= target <= 104
 * 通过次数9,712提交次数17,973
 */
public class Solution1774 {
    public static void main(String[] args) {
        Solution1774 solution1774 = new Solution1774();

       /* int[] baseCosts = {1, 7};
        int[] toppingCosts = {3, 4};
        int target = 10;*/

        int[] baseCosts = {2, 3};
        int[] toppingCosts = {4, 5, 100};
        int target = 18;
        int i = solution1774.closestCost1(baseCosts, toppingCosts, target);
        System.out.println(i);
    }

    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int asInt = Arrays.stream(baseCosts).max().getAsInt();
        int asInt1 = Arrays.stream(toppingCosts).max().getAsInt();
        boolean[][] dp = new boolean[baseCosts.length][asInt + asInt1 + target];
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < baseCosts.length; i++) {
            dp[i][baseCosts[i]] = true;
            int abs = Math.abs(baseCosts[i] - target);
            if (abs < min) {
                min = abs;
                res = baseCosts[i];
            }
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < dp.length; i++) {
            map.clear();
            for (int j = baseCosts[i]; j < dp[i].length; j++) {
                for (int k = 0; k < toppingCosts.length; k++) {
                    if ((j - toppingCosts[k]) > 0 && dp[i][j - toppingCosts[k]]) {
                        List<Integer> list1 = map.get(j - toppingCosts[k]);
                        if (list1 == null) {
                            List<Integer> list = new ArrayList<>();
                            list.add(k);
                            map.put(j, list);
                            dp[i][j] = true;
                        } else {
                            List<Integer> list = new ArrayList<>();
                            int finalK = k;
                            long count = list1.stream().filter(x -> x == finalK).count();
                            if (count < 2) {
                                for (int x : list1) {
                                    list.add(x);
                                }
                                list.add(k);
                                map.put(j, list);
                                dp[i][j] = true;
                            }
                        }
                        if (dp[i][j]) {
                            int abs = Math.abs(j - target);
                            if (abs < min) {
                                min = abs;
                                res = j;
                            } else if (abs == min) {
                                if (res > j) {
                                    res = j;
                                }
                            }
                        }
                    }
                }
            }
        }
        return res == 0 ? baseCosts[0] : res;
    }

    public int closestCost1(int[] baseCosts, int[] toppingCosts, int target) {
        int x = Arrays.stream(baseCosts).min().getAsInt();
        if (x >= target) {
            return x;
        }
        boolean[] can = new boolean[target + 1];
        int res = 2 * target - x;
        for (int b : baseCosts) {
            if (b <= target) {
                can[b] = true;
            } else {
                res = Math.min(res, b);
            }
        }
        for (int t : toppingCosts) {
            for (int count = 0; count < 2; ++count) {
                for (int i = target; i > 0; --i) {
                    if (can[i] && i + t > target) {
                        res = Math.min(res, i + t);
                    }
                    if (i - t > 0) {
                        can[i] = can[i] | can[i - t];
                    }
                }
            }
        }
        for (int i = 0; i <= res - target; ++i) {
            if (can[target - i]) {
                return target - i;
            }
        }
        return res;
    }

}
