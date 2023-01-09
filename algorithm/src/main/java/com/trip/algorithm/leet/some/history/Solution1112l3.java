package com.trip.algorithm.leet.some.history;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-12 19:58
 */
public class Solution1112l3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(4);
        arrayList.add(8);
        arrayList.add(7);
        List<Integer> collect = arrayList.stream().sorted(Comparator.comparingInt(x -> x)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(collect));
        Solution1112l3 solution1112l3 = new Solution1112l3();
        int[] nums1={1,2};
        int[] nums2={3,4};
        double medianSortedArrays = solution1112l3.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list= new ArrayList<>();
        List<Integer> list1= new ArrayList<>();

        for (Integer i:nums1){
            list.add(i);
        }
        for (Integer i:nums2){
            list.add(i);
        }

        list.addAll(list1);
        list = list.stream().sorted(Comparator.comparingInt(x -> x)).collect(Collectors.toList());
        if(list.size()%2==0){
           return (list.get(list.size()/2)+list.get((list.size()/2)-1))/2.0;
       }else{
           return list.get(list.size()/2);
       }
    }
}
