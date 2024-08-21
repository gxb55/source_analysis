package com.trip.algorithm.leet.l24.l08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution3137 {
    public static void main(String[] args) {
     ///  String word = "leetcodeleet"; int k = 4;
       String word = "leetcoleet"; int k = 2;
        int i = minimumOperationsToMakeKPeriodic(word, k);
        System.out.println(i);
    }

    public static int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        char[] charArray = word.toCharArray();
        int i = 0;
        int t = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < charArray.length) {
            while (t < k) {
                stringBuilder.append(charArray[i]);
                i++;
                t++;
            }

            if (t == k) {
                String string = stringBuilder.toString();
                stringBuilder.setLength(0);
                t = 0;
                int v = map.getOrDefault(string, 0) + 1;
                map.put(string, v);
            }
        }
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted((x, y) -> y.getValue() - x.getValue()).collect(Collectors.toList());
        Map.Entry<String, Integer> entry = collect.get(0);
        Integer value = entry.getValue();
        int count = (word.length() / k) - value;
        return count;
    }
}
