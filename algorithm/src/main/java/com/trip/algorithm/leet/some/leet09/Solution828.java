package com.trip.algorithm.leet.some.leet09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/9/6  9:38
 * @description Solution828
 */
public class Solution828 {
    public static void main(String[] args) {
        Solution828 solution828 = new Solution828();
        String str = "ABCA";
        int i = solution828.uniqueLetterString1(str);
        System.out.println(i);
    }
    public int uniqueLetterString1(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, ans = 0;
        int[] l = new int[n], r = new int[n];
        int[] cnts = new int[26];
        Arrays.fill(cnts, -1);
        for (int i = 0; i < n; i++) {
            int u = cs[i] - 'A';
            l[i] = cnts[u];
            cnts[u] = i;
        }
        Arrays.fill(cnts, n);
        for (int i = n - 1; i >= 0; i--) {
            int u = cs[i] - 'A';
            r[i] = cnts[u];
            cnts[u] = i;
        }
        for (int i = 0; i < n; i++) {
            ans += (i - l[i]) * (r[i] - i);
        }
        return ans;
    }
    public int uniqueLetterString(String s) {
        char[] chars = s.toCharArray();
        List<String> list = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();

        int index = 0;
        process(chars, index, tempList, list);
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        System.out.println(list);
        for (String str : list) {
            map.clear();
            char[] chars1 = str.toCharArray();
            for (Character character : chars1) {
                if (map.containsKey(character)) {
                    map.put(character, map.get(character) + 1);
                } else {
                    map.put(character, 1);
                }
            }
            Set<Map.Entry<Character, Integer>> collect = map.entrySet().stream().filter(x -> x.getValue() == 1).collect(Collectors.toSet());
            res = res + collect.size();
        }
        return res;
    }

    private void process(char[] chars, int index, List<Character> tempList, List<String> list) {
        if (index == chars.length) {
            StringBuilder stringBuilder = new StringBuilder();
            tempList.stream().forEach(x -> stringBuilder.append(x));
            list.add(stringBuilder.toString());
            return;
        }
        for (int i = index; i < chars.length; i++) {
            char aChar = chars[i];
            tempList.add(aChar);
            process(chars, i+1, tempList, list);
            tempList.remove(tempList.size() - 1);
        }
    }
}
