package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/6/14 17:36
 * 贪心 ：https://www.cnblogs.com/hust-chen/p/8646009.html
 */
public class Solution621 {
    public static void main(String[] args) {
       /* char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2; */

        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character character : tasks) {
            map.put(character, map.getOrDefault(character, 0) + 1);
        }
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> resMap = new HashMap<>();
        int index = 0;
        while (!map.isEmpty()) {
            List<Map.Entry<Character, Integer>> collect = map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).collect(Collectors.toList());
            for (int k = 0; k <= n && !map.isEmpty(); ) {
                if (k > collect.size() - 1) {
                    list.add('x');
                    k++;
                } else {
                    Map.Entry<Character, Integer> entry = collect.get(k);
                    Integer integer = resMap.get(entry.getKey());
                    if (integer == null || (index - integer > n)) {
                        list.add(entry.getKey());
                        resMap.put(entry.getKey(), index);
                        if (map.get(entry.getKey()) == 1) {
                            map.remove(entry.getKey());
                        } else {
                            map.put(entry.getKey(), entry.getValue() - 1);
                        }
                        k++;
                    } else {
                        list.add('x');
                    }
                }
                index++;
            }
        }
       // System.out.println(list);
        return list.size();
    }
}
