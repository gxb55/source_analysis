package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @createTime 2022年04月01日 21:52:00
 * 954. 二倍数对数组
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 3 * 104
 * arr.length 是偶数
 * -105 <= arr[i] <= 105
 * 通过次数30,304提交次数80,284
 */
public class Leet_954 {
    public static void main(String[] args) {
        int[] arr = {4, -2, 2, -4};
        Leet_954 leet_954 = new Leet_954();
        boolean b = leet_954.canReorderDoubled(arr);
        System.out.println(b);
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return process(map);
    }

    private boolean process(Map<Integer, Integer> map) {
        if (map.size() == 0) {
            return true;
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Map.Entry<Integer, Integer> entry = entrySet.stream().findFirst().get();

        Integer key = entry.getKey();
        Integer integer = map.get(key * 2);
        Integer integer1 = map.get(key / 2);
        if (integer != null) {
            integer--;
            if (integer == 0) {
                map.remove(key * 2);
            } else {
                map.put(key * 2, integer);
            }
            Integer value = entry.getValue();
            value--;
            if (value == 0) {
                map.remove(key);
            } else {
                map.put(key, value);
            }
           return process(map);
        } else if (integer1 != null) {
            integer1--;
            if (integer1 == 0) {
                map.remove(key / 2);
            } else {
                map.put(key / 2, integer1);
            }
            Integer value = entry.getValue();
            value--;
            if (value == 0) {
                map.remove(key);
            } else {
                map.put(key, value);
            }
            return process(map);
        } else {
            return false;
        }
    }
}
