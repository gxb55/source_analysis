package com.trip.algorithm.leet.l24.l09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/9/27 15:16
 */
public class Solution2516 {
    public static void main(String[] args) {
     /*   String s = "aabaaaacaabc";
        int k = 2;*/

        String s = "cbbac";
        int k = 1;
        int i = takeCharacters(s, k);
        System.out.println(i);
    }

    public static int takeCharacters(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('b', 0);
        map.put('c', 0);
        char[] charArray = s.toCharArray();
        int i = 0;
        for (; i < charArray.length; i++) {
            Character c = charArray[i];
            map.put(c, map.get(c) + 1);
            if (map.entrySet().stream().allMatch(x -> x.getValue() >= k)) {
                break;
            }
        }
        boolean b = map.entrySet().stream().anyMatch(x -> x.getValue() < k);
        if (b) {
            return -1;
        }
        int max = i + 1;
        int right = charArray.length - 1;
        while (i >= 0) {
            while (i >= 0 && map.entrySet().stream().allMatch(x -> x.getValue() >= k)) {
                max = Math.min(max, i + 1 + (charArray.length - right - 1));
                map.put(charArray[i], map.get(charArray[i]) - 1);
                i--;
            }
            if (map.entrySet().stream().allMatch(x -> x.getValue() >= k)) {
                max = Math.min(max, i + 1 + (charArray.length - right - 1));
            }
            while (right > i) {
                map.put(charArray[right], map.get(charArray[right]) + 1);
                right--;
                if (map.entrySet().stream().allMatch(x -> x.getValue() >= k)) {
                    max = Math.min(max, i + 1 + (charArray.length - right - 1));
                    break;
                }
            }

        }
        return max;
    }
}
