package com.trip.algorithm.leet.some.Leet2308;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @createTime 2023年08月27日 16:13:00
 * intervals = {{1,3},{2,6},{8,10},{15,18}}
 * 输出：{{1,6},{8,10},{15,18}}
 * 解释：区间 {1,3} 和 {2,6} 重叠, 将它们合并为 {1,6}.
 * 示例 2：
 *
 * 输入：intervals = {{1,4},{4,5}}
 * 输出：{{1,5}}
 */
public class Solution54 {
    public static void main(String[] args) {
        Solution54 solution54 =new Solution54();
        //int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
       // int[][] intervals = {{1,4},{4,5}};
        int[][] intervals = {{1,4},{2,3}};
        int[][] merge = solution54.merge(intervals);
        for (int[] a:merge){
            System.out.println(Arrays.toString(a));
        }
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        List<int[]> collect = Arrays.stream(intervals).sorted((x, y) -> x[0] - y[0]).collect(Collectors.toList());
        int[] last = null;
        for (int[] arr : collect) {
            if (last == null) {
                last = arr;
            } else {
                if (arr[0] <= last[1]) {
                    last[1] = Math.max(arr[1],last[1]);
                } else {
                    list.add(last);
                    last = arr;
                }
            }
        }
        list.add(last);
        int size = list.size();
        int[][] res = new int[size][2];
        for (int i = 0; i < size; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
