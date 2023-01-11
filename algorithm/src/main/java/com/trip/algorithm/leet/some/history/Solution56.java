package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/4/25  10:25
 * @description 56
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 * 通过次数429,017提交次数885,875
 */
public class Solution56 {
    public static void main(String[] args) {
        //int[][] arr = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] arr = {{1,4},{0,4}};
        //int[][] arr = {{1,4},{2,3}};
       // int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution56 solution56 = new Solution56();
        int[][] merge = solution56.merge(arr);
        for (int[] p : merge) {
            System.out.println(Arrays.toString(p));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> collect = Arrays.stream(intervals).sorted(Comparator.comparingInt(x -> x[0])).collect(Collectors.toList());
        List<int[]> result = new ArrayList<>();
        int[] cur = null;
        for (int i = 0; i < collect.size(); i++) {
            int[] ints = collect.get(i);
            if (cur == null) {
                cur = ints;
            } else if (cur[1] >= ints[0]) {
                if(cur[1] < ints[1]){
                    cur[1] = ints[1];
                }
            } else {
                result.add(cur);
                cur = ints;
            }
        }
        result.add(cur);
        int[][] res = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
