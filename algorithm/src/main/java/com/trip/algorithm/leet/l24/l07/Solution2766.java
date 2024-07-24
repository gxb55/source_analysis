package com.trip.algorithm.leet.l24.l07;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/7/24 10:18
 */
public class Solution2766 {

    public static void main(String[] args) {

    }

    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        Set<Integer> set =new HashSet<>();
        for (int x:nums){
            set.add(x);
        }
        for (int i = 0; i < moveFrom.length; i++) {
            int from = moveFrom[i];
            int to = moveTo[i];
            boolean remove = set.remove(from);
            if(remove){
                set.add(to);
            }
        }
        List<Integer> collect = set.stream().sorted((x, y) -> x - y).collect(Collectors.toList());
        return collect;
    }
}
