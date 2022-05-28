package com.trip.algorithm.leet.some;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 * <p>
 * 2100. 适合打劫银行的日子
 * 你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始编号。同时给你一个整数 time 。
 * <p>
 * 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子：
 * <p>
 * 第 i 天前和后都分别至少有 time 天。
 * 第 i 天前连续 time 天警卫数目都是非递增的。
 * 第 i 天后连续 time 天警卫数目都是非递减的。
 * 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ... >= security[i] <= ... <= security[i + time - 1] <= security[i + time].
 * <p>
 * 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：security = [5,3,3,3,5,6,2], time = 2
 * 输出：[2,3]
 * 解释：
 * 第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= security[4] 。
 * 第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= security[5] 。
 * 没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
 * 示例 2：
 * <p>
 * 输入：security = [1,1,1,1,1], time = 0
 * 输出：[0,1,2,3,4]
 * 解释：
 * 因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
 * 示例 3：
 * <p>
 * 输入：security = [1,2,3,4,5,6], time = 2
 * 输出：[]
 * 解释：
 * 没有任何一天的前 2 天警卫数目是非递增的。
 * 所以没有适合打劫银行的日子，返回空数组。
 * 示例 4：
 * <p>
 * 输入：security = [1], time = 5
 * 输出：[]
 * 解释：
 * 没有日子前面和后面有 5 天时间。
 * 所以没有适合打劫银行的日子，返回空数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= security.length <= 105
 * 0 <= security[i], time <= 105
 *
 *
 *
 *
 *
 *
 * 动态规划，前缀问题
 */
public class Leet_2100 {
    /**
     * 先递减，再递增
     *
     * @param security
     * @param time
     * @return
     */
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> list = new ArrayList<>();
        if (security == null || security.length <= time) {
            return list;
        }
        int length = security.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i = 1; i < length; i++) {
            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }
        for (int i = length - 2; i > 0; i--) {
            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }

        for (int i = 0; i < length; i++) {
            if(left[i]>=time&&right[i]>=time){
                list.add(i);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Leet_2100 leet_2100 = new Leet_2100();
        int[] security = {2,0,5,3,4};
        int time = 1;
        List<Integer> list = leet_2100.goodDaysToRobBank(security, time);
        System.out.println(list);
    }
}
