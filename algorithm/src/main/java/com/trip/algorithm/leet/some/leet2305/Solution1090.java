package com.trip.algorithm.leet.some.leet2305;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2023/5/23 09:54
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 *
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 *
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/largest-values-from-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1090 {
    public static void main(String[] args) {
       /* int[] values = {5,4,3,2,1};
        int[] labels = {1,1,2,2,3};
        int numWanted = 3, useLimit = 1;*/

        int[] values = {9,8,8,7,6};
        int[] labels = {0,0,0,1,1};
        int numWanted = 3, useLimit = 1;
        int i = largestValsFromLabels(values,labels,numWanted,useLimit);
        System.out.println(i);
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int length = values.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i = 0; i < length; i++) {
            queue.add(new int[]{values[i], labels[i]});
        }
        int res = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (!queue.isEmpty()&&count < numWanted) {
            int[] poll = queue.poll();
            int i = poll[0];
            int i1 = poll[1];
            if ((map.getOrDefault(i1, 0) + 1) <= useLimit) {
                map.put(i1, map.getOrDefault(i1, 0) + 1);
                count++;
                res += i;
            }
        }

        return res;
    }
}
