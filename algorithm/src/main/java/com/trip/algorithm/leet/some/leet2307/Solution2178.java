package com.trip.algorithm.leet.some.leet2307;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年07月07日 20:59:00
 * 示例 1：
 * <p>
 * 输入：finalSum = 12
 * 输出：[2,4,6]
 * 解释：以下是一些符合要求的拆分：(2 + 10)，(2 + 4 + 6) 和 (4 + 8) 。
 * (2 + 4 + 6) 为最多数目的整数，数目为 3 ，所以我们返回 [2,4,6] 。
 * [2,6,4] ，[6,2,4] 等等也都是可行的解。
 * 示例 2：
 * <p>
 * 输入：finalSum = 7
 * 输出：[]
 * 解释：没有办法将 finalSum 进行拆分。
 * 所以返回空数组。
 * 示例 3：
 * <p>
 * 输入：finalSum = 28
 * 输出：[6,8,2,12]
 * 解释：以下是一些符合要求的拆分：(2 + 26)，(6 + 8 + 2 + 12) 和 (4 + 24) 。
 * (6 + 8 + 2 + 12) 有最多数目的整数，数目为 4 ，所以我们返回 [6,8,2,12] 。
 * [10,2,4,12] ，[6,2,4,16] 等等也都是可行的解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-split-of-positive-even-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution2178 {
    public static void main(String[] args) {
        Long finalSum = 7L;
         finalSum = 12L;
         finalSum =28L;
        List<Long> list = maximumEvenSplit(finalSum);
        System.out.println(list);
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> list = new ArrayList<>();
        long cur = 2;
        while ((finalSum-cur) >= 0) {
            list.add(cur);
            finalSum -= cur;
            cur += 2;
        }
        if(finalSum==0){
            return list;
        }
        if (finalSum % 2 == 0) {
            Long remove = list.remove(list.size() - 1);
            list.add(remove + finalSum);
            return list;
        }
        return new ArrayList<>();
    }
}
