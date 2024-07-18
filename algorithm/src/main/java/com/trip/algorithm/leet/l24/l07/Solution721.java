package com.trip.algorithm.leet.l24.l07;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/7/15 21:05
 * @description TODO
 */
public class Solution721 {

    public static void main(String[] args) {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> resultList = new ArrayList<>();
        for (String[] arr : accounts) {
            resultList.add(Arrays.stream(arr).collect(Collectors.toList()));
        }

        List<List<String>> lists = accountsMerge(resultList);
        lists.stream().forEach(x -> {
            System.out.println(x);
        });

    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> list = accounts.get(i);
            int finalI = i;
            list.stream().skip(1).forEach(x -> {
                List<Integer> orDefault = map.getOrDefault(x, new ArrayList<>());
                orDefault.add(finalI);
                map.put(x, orDefault);
            });
        }
        List<List<String>> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (set.contains(i)) {
                continue;
            }
            List<String> curList = new ArrayList<>();
            Set<Integer> list = new HashSet<>();
            list.add(i);
            curList.add(accounts.get(i).get(0));
            while (true) {
                int count = list.size();
                map.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(t -> list.contains(t)))
                        .forEach(t -> list.addAll(t.getValue()));
                if (count == list.size()) {
                    break;
                }
            }
            set.addAll(list);
            List<String> collect = map.entrySet().stream().filter(x -> x.getValue().stream().anyMatch(t -> list.contains(t))).map(t -> t.getKey()).collect(Collectors.toList());
            collect.sort((x, y) -> x.compareTo(y));
            collect.stream().forEach(z -> map.remove(z));
            curList.addAll(collect);
            resultList.add(curList);
        }
        return resultList;
    }
}
