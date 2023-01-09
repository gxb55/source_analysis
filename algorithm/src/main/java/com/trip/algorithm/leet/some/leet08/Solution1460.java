package com.trip.algorithm.leet.some.leet08;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/24  19:14
 * @description 1460. 通过翻转子数组使两个数组相等
 */
public class Solution1460 {
    public static void main(String[] args) {
        Solution1460 solution1460 = new Solution1460();
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 5};
        boolean b = solution1460.canBeEqual(target, arr);
        System.out.println(b);
    }

    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (Integer integer : target) {
            map1.put(integer, map1.getOrDefault(integer, 0) + 1);
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (Integer integer : arr) {
            map2.put(integer, map2.getOrDefault(integer, 0) + 1);
        }
        if(map1.size()!=map2.size()){
            return false;
        }
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if (!entry.getValue().equals(map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}
