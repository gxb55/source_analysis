package com.trip.algorithm.leet.l24.l01;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2788 {
    public static void main(String[] args) {

        Solution2788 solution2788 = new Solution2788();
        String[] arr = {"one.two.three", "four.five", "six"};
        char se = '.';
        List<String> list = solution2788.splitWordsBySeparator(List.of(arr), se);
        System.out.println(JSON.toJSONString(list));
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            String st = String.valueOf("\\") + separator;
            String[] split = str.split(st);
            Arrays.stream(split).filter(x -> x.length() != 0).forEach(x -> list.add(x));
        }
        return list;
    }
}
