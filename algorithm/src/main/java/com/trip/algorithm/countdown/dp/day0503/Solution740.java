package com.trip.algorithm.countdown.dp.day0503;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年05月03日 15:12:00
 */
public class Solution740 {
    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        int[] nums = {3, 4, 2};
        int i = solution740.deleteAndEarn(nums);
        System.out.println(i);
    }

    public int deleteAndEarn(int[] nums) {
        int[] trans = new int[10001];
        for (int i = 0; i < nums.length; i ++) {
            trans[nums[i]] += nums[i];
        }
        int[] dp = new int[10001];

        dp[0] = 0;
        dp[1] = trans[1];
        for (int i = 2; i < trans.length; i ++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + trans[i]);
        }

        return dp[dp.length - 1];
    }

    Map<Map<Integer, Integer>, Integer> integerMap = new HashMap<>();

    private int process(Map<Integer, Integer> map, List<Integer> list, int index) {
        if (index >= list.size()) {
            return 0;
        }
        Integer integer = integerMap.entrySet().stream().filter(x -> x.getKey().size() == map.size()).filter(x -> {
            return map.entrySet().stream().allMatch(z -> z.getValue().equals(x.getKey().get(z.getKey())));
        }).map(x -> x.getValue()).findFirst().orElse(null);
        if (integer != null) {
            return integer;
        }
        Map<Integer, Integer> map1 = new HashMap<>(map);
        Integer val = list.get(index);
        Integer count = map.get(val);
        count = count == null ? 0 : count;
        map.remove(val + 1);
        map.remove(val - 1);
        int max = Math.max(process(map1, list, index + 1), process(map, list, index + 1) + val * count);
        integerMap.put(map1, max);
        return max;
    }
}
