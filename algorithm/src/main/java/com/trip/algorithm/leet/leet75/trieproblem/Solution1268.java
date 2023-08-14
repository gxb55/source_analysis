package com.trip.algorithm.leet.leet75.trieproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/8/14 17:32
 */
public class Solution1268 {
    public static void main(String[] args) {
        Solution1268 solution1268 =new Solution1268();
       /* String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";*/

        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";
        List<List<String>> list = solution1268.suggestedProducts(products,searchWord);
        for (List<String> strings:list){
            System.out.println(strings);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            stringBuilder.append(c);
            List<String> collect = Arrays.stream(products).filter(x -> x.startsWith(stringBuilder.toString())).sorted((x, y) -> x.compareTo(y)).collect(Collectors.toList());
            if (collect.size() > 3) {
                List<String> list1 = collect.subList(0, 3);
                list.add(list1);
            }else {
                list.add(collect);
            }
            if (collect.size() == 0) {
                break;
            }
        }
        while (list.size() < searchWord.length()) {
            list.add(new ArrayList<>());
        }
        return list;
    }
}
