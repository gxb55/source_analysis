package com.trip.algorithm.leet.some.history;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/3/24  20:27
 * @description 1094
 * 1094. 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 * 通过次数39,518提交次数69,539
 */
public class Solution1094 {
    public static void main(String[] args) {
        Solution1094 solution1094 = new Solution1094();

        int[][] arr = {{4,3,4}, {3,2,4}, {1,8,9}, {7,2,5}};
        int capacity = 14;
        boolean b = solution1094.carPooling(arr, capacity);
        System.out.println(b);
    }

    public boolean carPooling(int[][] trips, int capacity) {

        Arrays.sort(trips, Comparator.comparingInt(x -> x[1]));
        Set<int[]> queue = new HashSet<>();
        int right = 0;
        int left = 0;
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            if (i == 0) {
                capacity = capacity - num;
                right = to;
            } else {
                if (to >= right) {
                    right = to;
                }
                left =from;
                capacity = capacity - num;
            }
            int finalLeft = left;
            List<int[]> collect = queue.stream().filter(x -> x[2] <= finalLeft).collect(Collectors.toList());
            queue.removeAll(collect);
            for (int[] arr : collect) {
                capacity = capacity + arr[0];
            }

            queue.add(trips[i]);
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}
