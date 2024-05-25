package com.trip.algorithm.leet.l24.l05;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/5/23 16:43
 * @description TODO
 */
public class Solution2225 {

    public static void main(String[] args) {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> winners = findWinners(matches);
        System.out.println(JSON.toJSONString(winners));
    }

    //matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
    public static List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] arr : matches) {
            int x = arr[0];
            int y = arr[1];
            int[] orDefault = map.getOrDefault(x, new int[2]);
            orDefault[0]++;
            map.put(x, orDefault);

            int[] orDefault1 = map.getOrDefault(y, new int[2]);
            orDefault1[1]++;
            map.put(y, orDefault1);
        }
        // answer[0] 是所有 没有 输掉任何比赛的玩家列表。
        //answer[1] 是所有恰好输掉 一场 比赛的玩家列表
        List<Integer> collect1 = map.entrySet().stream().filter(x -> x.getValue()[1] == 0).map(x -> x.getKey()).sorted((x,y)->x-y).collect(Collectors.toList());
        List<Integer> collect2 = map.entrySet().stream().filter(x -> x.getValue()[1] == 1).map(x -> x.getKey()).sorted((x,y)->x-y).collect(Collectors.toList());
        List<List<Integer>> list = new ArrayList<>();
        list.add(collect1);
        list.add(collect2);
        return list;
    }

}
