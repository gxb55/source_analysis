package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/6/13  18:33
 * @description 1051
 * 1051. 高度检查器
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * <p>
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * <p>
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * <p>
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 * 示例 2：
 * <p>
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 解释：
 * 高度：[5,1,2,3,4]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都不匹配。
 * 示例 3：
 * <p>
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 高度：[1,2,3,4,5]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都匹配。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * 通过次数54,013提交次数68,067
 */
public class Solution1051 {
    public static void main(String[] args) {
        Solution1051 solution1051 = new Solution1051();
        int[] heights = {1,1,4,2,1,3};
        int i = solution1051.heightChecker(heights);
        System.out.println(i);
    }

    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heights[i];
        }
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (heights[i] != arr[i]) {
                res++;
            }
        }
        return res;
    }
}
