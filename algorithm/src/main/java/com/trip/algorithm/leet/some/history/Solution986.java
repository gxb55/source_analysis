package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2022年05月31日 10:48:00
 * 986. 区间列表的交集
 * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
 * <p>
 * 返回这 两个区间列表的交集 。
 * <p>
 * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
 * <p>
 * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * 示例 2：
 * <p>
 * 输入：firstList = [[1,3],[5,9]], secondList = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：firstList = [], secondList = [[4,8],[10,12]]
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：firstList = [[1,7]], secondList = [[3,10]]
 * 输出：[[3,7]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= firstList.length, secondList.length <= 1000
 * firstList.length + secondList.length >= 1
 * 0 <= starti < endi <= 109
 * endi < starti+1
 * 0 <= startj < endj <= 109
 * endj < startj+1
 * 通过次数45,306提交次数66,209
 */
public class Solution986 {
    public static void main(String[] args) {
        Solution986 solution986 = new Solution986();
       // int[][] firstList = {{1, 7}}, secondList = {{3, 10}};
        int[][] firstList = {{0,2},{5,10},{13,23},{24,25}}, secondList = {{1,5},{8,12},{15,24},{25,26}};
        int[][] ints = solution986.intervalIntersection(firstList, secondList);
        for (int[] arr : ints) {
            System.out.println(Arrays.toString(arr));
        }
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        int len1 = firstList.length;
        int len2 = secondList.length;
        int index1 = 0;
        int index2 = 0;
        List<int[]> list = new ArrayList<>();
        while (index1 < len1 && index2 < len2) {
            int[] ints1 = firstList[index1];
            int[] ints2 = secondList[index2];

            if (ints1[0] >= ints2[0] && ints1[0] <= ints2[1]) {
                if (ints1[1] >= ints2[1]) {
                    list.add(new int[]{ints1[0], ints2[1]});
                    index2++;
                } else {
                    list.add(new int[]{ints1[0], ints1[1]});
                    index1++;
                }
            } else if (ints2[0] >= ints1[0] && ints2[0] <= ints1[1]) {
                if (ints2[1] >= ints1[1]) {
                    list.add(new int[]{ints2[0], ints1[1]});
                    index1++;
                } else {
                    list.add(new int[]{ints2[0], ints2[1]});
                    index2++;
                }
            } else if (ints2[0] > ints1[1]) {
                index1++;
            } else if (ints1[0] > ints2[1]) {
                index2++;
            }
        }
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
