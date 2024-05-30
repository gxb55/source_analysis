package com.trip.algorithm.leet.l24.l05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/5/30 14:25
 * @description TODO
 */
public class Solution2982 {

    public static void main(String[] args) {
        Solution2982 solution2982 = new Solution2982();
          String s = "aaaa";
      //  String s = "abcdef";
        int i = solution2982.maximumLength(s);
        System.out.println(i);
    }

    public int maximumLength(String s) {
        Map<Integer, Integer>[] arr = new Map[26];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HashMap<>();
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            char c = charArray[i];
            while (j < s.length() && c == charArray[j]) {
                j++;
            }
            j--;
            process(arr, i, j, c);
            i = j;
        }
        List<Entry<Integer, Integer>> collect = Arrays.stream(arr).flatMap(x -> x.entrySet().stream()).filter(x -> x.getValue() >= 3).sorted((x, y) -> y.getKey() - x.getKey()).collect(Collectors.toList());
        if (collect.size() == 0) {
            return -1;
        }
        return collect.get(0).getKey();
    }

    private void process(Map<Integer, Integer>[] arr, int left, int right, char c) {
        int len = right - left + 1;
        Map<Integer, Integer> map = arr[c - 'a'];
        int t = len;
        for (int i = 1; i <= len; i++) {
            int v = map.getOrDefault(t, 0) + i;
            map.put(t, v);
            t--;
        }
    }
}
