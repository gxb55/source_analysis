package com.trip.algorithm.leet.l24.l10;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution1436 {
    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {
        List<String> list = new ArrayList<>();
        paths.stream().forEach(x -> {
            list.addAll(x);
        });
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        paths.stream().forEach(x -> {
            collect.remove(x.get(0));
        });
        return collect.get(0);
    }
}
