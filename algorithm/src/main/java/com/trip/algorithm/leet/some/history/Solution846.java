package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2021/12/30  15:52
 * @description 一手顺子
 * 846. 一手顺子
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * 输出：true
 * 解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 * <p>
 * 输入：hand = [1,2,3,4,5], groupSize = 4
 * 输出：false
 * 解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hand.length <= 104
 * 0 <= hand[i] <= 109
 * 1 <= groupSize <= hand.length
 * <p>
 * <p>
 * 注意：此题目与 1296 重复：https://leetcode-cn.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 * <p>
 * 通过次数23,099提交次数40,753
 */
public class Solution846 {
    public static void main(String[] args) {
        Solution846 solution846 = new Solution846();
        int[] arr = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int k = 3;
        boolean nStraightHand = solution846.isNStraightHand(arr, k);
        System.out.println(nStraightHand);
    }

    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(hand);
        for (Integer x : hand) {
            list.add(x);
        }

        while (!list.isEmpty()) {
            Integer remove = list.get(0);
            for (int i = 0; i < groupSize; i++) {
                boolean remove1 = list.remove(remove);
                if (!remove1) {
                    return false;
                }
                remove = remove + 1;
            }
        }
        return true;
    }
}
