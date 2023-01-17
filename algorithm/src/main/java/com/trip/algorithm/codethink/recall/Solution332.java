package com.trip.algorithm.codethink.recall;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/1/16 15:26
 * @description 332
 */
public class Solution332 {
    public static void main(String[] args) {
        Solution332 solution332 = new Solution332();
        //      String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
         String[][] tickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
       // String[][] tickets = {{"AXA", "EZE"}, {"EZE", "AUA"}, {"ADL", "JFK"}, {"ADL", "TIA"}, {"AUA", "AXA"}, {"EZE", "TIA"}, {"EZE", "TIA"}, {"AXA", "EZE"}, {"EZE", "ADL"}, {"ANU", "EZE"}, {"TIA", "EZE"}, {"JFK", "ADL"}, {"AUA", "JFK"}, {"JFK", "EZE"}, {"EZE", "ANU"}, {"ADL", "AUA"}, {"ANU", "AXA"}, {"AXA", "ADL"}, {"AUA", "JFK"}, {"EZE", "ADL"}, {"ANU", "TIA"}, {"AUA", "JFK"}, {"TIA", "JFK"}, {"EZE", "AUA"}, {"AXA", "EZE"}, {"AUA", "ANU"}, {"ADL", "AXA"}, {"EZE", "ADL"}, {"AUA", "ANU"}, {"AXA", "EZE"}, {"TIA", "AUA"}, {"AXA", "EZE"}, {"AUA", "SYD"}, {"ADL", "JFK"}, {"EZE", "AUA"}, {"ADL", "ANU"}, {"AUA", "TIA"}, {"ADL", "EZE"}, {"TIA", "JFK"}, {"AXA", "ANU"}, {"JFK", "AXA"}, {"JFK", "ADL"}, {"ADL", "EZE"}, {"AXA", "TIA"}, {"JFK", "AUA"}, {"ADL", "EZE"}, {"JFK", "ADL"}, {"ADL", "AXA"}, {"TIA", "AUA"}, {"AXA", "JFK"}, {"ADL", "AUA"}, {"TIA", "JFK"}, {"JFK", "ADL"}, {"JFK", "ADL"}, {"ANU", "AXA"}, {"TIA", "AXA"}, {"EZE", "JFK"}, {"EZE", "AXA"}, {"ADL", "TIA"}, {"JFK", "AUA"}, {"TIA", "EZE"}, {"EZE", "ADL"}, {"JFK", "ANU"}, {"TIA", "AUA"}, {"EZE", "ADL"}, {"ADL", "JFK"}, {"ANU", "AXA"}, {"AUA", "AXA"}, {"ANU", "EZE"}, {"ADL", "AXA"}, {"ANU", "AXA"}, {"TIA", "ADL"}, {"JFK", "ADL"}, {"JFK", "TIA"}, {"AUA", "ADL"}, {"AUA", "TIA"}, {"TIA", "JFK"}, {"EZE", "JFK"}, {"AUA", "ADL"}, {"ADL", "AUA"}, {"EZE", "ANU"}, {"ADL", "ANU"}, {"AUA", "AXA"}, {"AXA", "TIA"}, {"AXA", "TIA"}, {"ADL", "AXA"}, {"EZE", "AXA"}, {"AXA", "JFK"}, {"JFK", "AUA"}, {"ANU", "ADL"}, {"AXA", "TIA"}, {"ANU", "AUA"}, {"JFK", "EZE"}, {"AXA", "ADL"}, {"TIA", "EZE"}, {"JFK", "AXA"}, {"AXA", "ADL"}, {"EZE", "AUA"}, {"AXA", "ANU"}, {"ADL", "EZE"}, {"AUA", "EZE"}};
        List<List<String>> list = new ArrayList<>();

        for (String[] arr : tickets) {
            List<String> list1 = new ArrayList<>();
            list1.add(arr[0]);
            list1.add(arr[1]);
            list.add(list1);
        }
        List<String> itinerary = solution332.findItinerary(list);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            String from = tickets.get(i).get(0);
            String to = tickets.get(i).get(1);
            if (map.containsKey(from)) {
                map.get(from).add(to);
            } else {
                List<String> list = new ArrayList<>();
                list.add(to);
                map.put(from, list);
            }
        }
        Map<String, String[]> map1 = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> value = entry.getValue();
            List<String> collect = value.stream().sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());
            String[] strings = collect.toArray(new String[collect.size()]);
            map1.put(entry.getKey(), strings);
        }
        String first = "JFK";
        List<List<String>> list = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        process(first, map1, 0, list, temp, tickets.size());
        if (list.isEmpty()) {
            return null;
        }
        list.get(0).add(0, first);
        return list.get(0);
    }


    Boolean flag =true;
    private void process(String first, Map<String, String[]> map, int index, List<List<String>> list, List<String> temp, int size) {
        if (temp.size() == size) {
           // System.out.println(temp);
            list.add(new ArrayList<>(temp));
            flag=false;
            return;
        }
        if(!flag){
            return;
        }
        String[] list1 = map.get(first);
        if (list1 == null) {
            return;
        }
        boolean b = Arrays.stream(list1).allMatch(x -> x.equals(""));
        if (b) {
            return;
        }
        for (int i = index; i < list1.length; i++) {
            String s = list1[i];
            /*if (first.equals(s)) {
                continue;
            }*/
            if(s.equals("")){
                continue;
            }
            temp.add(s);
            list1[i] = "";
            process(s, map, 0, list, temp, size);
            list1[i] = s;
            temp.remove(temp.size() - 1);
            if(!flag){
                return;
            }
        }
    }
}
