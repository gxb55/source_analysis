package com.trip.algorithm.leet.some.leet2302;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年02月05日 10:15:00
 */
public class Solution1798 {
    public static void main(String[] args) {

    }

    public int getMaximumConsecutive1(int[] coins) {
        int cur=1;
        Arrays.sort(coins);
        for (int x:coins){
            if(x>cur){
                break;
            }
            cur+=x;
        }
        return cur;
    }

    public int getMaximumConsecutive(int[] coins) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<List<Integer>>> resultMap = new HashMap<>();
        for (int i : coins) {
            Integer orDefault = map.getOrDefault(i, 0);
            map.put(i, orDefault + 1);
        }
        int cur = 0;
        int left;
        int right;
        do {
            cur++;
            resultMap.put(cur, new ArrayList<>());
            if (map.containsKey(cur)) {
                List<Integer> list = new ArrayList<>();
                list.add(cur);
                resultMap.get(cur).add(list);
            }
            left = 1;
            right = cur - 1;
            while (left <= right && (right + left == cur)) {
                List<List<Integer>> list = resultMap.get(left);
                List<List<Integer>> list1 = resultMap.get(right);
                for (List<Integer> listx : list1) {
                    for (List<Integer> listy : list) {
                        List<Integer> list2 = new ArrayList<>();
                        list2.addAll(listx);
                        list2.addAll(listy);
                        if (check(list2, map)) {
                            resultMap.get(cur).add(list2);
                        }
                    }
                }

            }
        } while (resultMap.get(cur).size() > 0);
        return cur - 1;
    }

    private boolean check(List<Integer> list2, Map<Integer, Integer> map) {
        Map<Integer, Integer> tempMap = new HashMap<>();
        for (int x : list2) {
            Integer orDefault = tempMap.getOrDefault(x, 0);
            tempMap.put(x, orDefault + 1);
        }
        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            if (map.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
