package com.trip.algorithm.leet.leet75.backtrackproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/9/8 16:09
 */
public class Solution17 {
    public static void main(String[] args) {
        Solution17 solution17 =new Solution17();
        String digits = "23";
        List<String> list = solution17.letterCombinations(digits);
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return null;
        }
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', new ArrayList<>());
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        char[] chars1 = digits.toCharArray();
        List<List<String>> list = new ArrayList<>();
        for (Character character : chars1) {
            if (character == '1') {
                continue;
            }
            List<String> list1 = map.get(character);
            list.add(list1);
        }
        LinkedList<String> list1 = new LinkedList<>();
        process(list,0,list1);
        return res;
    }
    List<String> res =new ArrayList<>();
    private void process(List<List<String>> list, int index, LinkedList<String> linkedList) {
        if(index>=list.size()){
            String collect = linkedList.stream().collect(Collectors.joining());
            res.add(collect);
            return;
        }
        List<String> list1 = list.get(index);
        for (int i = 0; i < list1.size(); i++) {
            linkedList.addLast(list1.get(i));
            process(list,index+1,linkedList);
            linkedList.pollLast();
        }
    }


}
