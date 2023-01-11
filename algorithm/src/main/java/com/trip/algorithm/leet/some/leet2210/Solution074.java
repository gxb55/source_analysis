package com.trip.algorithm.leet.some.leet2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2022年10月30日 22:40:00
 * 剑指 Offer II 074. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
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
 */
public class Solution074 {
    public static void main(String[] args) {
        Solution074 solution074 = new Solution074();
        //int[][] arr = {{1, 3},{1,2}, {2, 6}, {8, 10}, {15, 18}};
       // int[][] arr = {{1,4},{4,5}};
       // int[][] arr = {{1,4},{0,1}};
        int[][] arr = {{1,4},{2,3}};
        int[][] merge = solution074.merge(arr);
        for (int[] cur : merge) {
            System.out.println(Arrays.toString(cur));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        List<int[]> collect = Arrays.stream(intervals).sorted((x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return x[0] - y[0];
            }
        }).collect(Collectors.toList());
        int len = intervals.length;
        list.add(collect.get(0));
        for (int i = 1; i < len; i++) {
            int[] ints = list.get(list.size() - 1);
            int[] cur = collect.get(i);
            if (cur[0] <= ints[1]) {
                ints[1] = Math.max(ints[1],cur[1]);
            } else {
                list.add(cur);
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
