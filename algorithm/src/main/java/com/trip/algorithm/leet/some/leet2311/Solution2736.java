package com.trip.algorithm.leet.some.leet2311;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/11/17 10:40
 */
public class Solution2736 {
    public static void main(String[] args) {
        Solution2736 solution2736 =new Solution2736();
        int[] nums1 = {4,3,1,2}, nums2 = {2,4,9,5}; int[][] queries = {{4,1},{1,3},{2,5}};
        int[] ints = solution2736.maximumSumQueries(nums1,nums2,queries);
        System.out.println(Arrays.toString(ints));
    }

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list1.add(new int[]{i, nums1[i]});
        }
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            list2.add(new int[]{i, nums2[i]});
        }
        list1.sort((x, y) -> x[1] - y[1]);
        list2.sort((x, y) -> x[1] - y[1]);
        int index = 0;
        int[] a = new int[queries.length];
        Map<String,Integer> map =new HashMap<>();
        for (int[] arr : queries) {
            String s = arr[0] + "_" + arr[1];
            if(map.containsKey(s)){
                a[index] = map.get(s);
                index++;
                continue;
            }
            List<Integer> res = getRes(list1, arr[0]);
            if(res.size()==0){
                a[index] = -1;
                index++;
                map.put(s,-1);
                continue;
            }
            List<Integer> res1 = getRes(list2, arr[1]);
            if(res1.size()==0){
                a[index] = -1;
                index++;
                map.put(s,-1);
                continue;
            }
            res1.retainAll(res);
            int max = 0;
            if (res1.size() == 0) {
                a[index] = -1;
                map.put(s,-1);
            } else {
                for (int i : res1) {
                    max = Math.max(nums1[i] + nums2[i], max);
                }
                a[index] = max;
                map.put(s,max);
            }
            index++;
        }
        return a;
    }

    private List<Integer> getRes(List<int[]> list, int val) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid)[1] >= val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        List<Integer> collect = list.stream().skip(left).map(x -> x[0]).collect(Collectors.toList());
        return collect;
    }
}
