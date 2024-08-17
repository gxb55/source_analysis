package com.trip.algorithm.leet.l24.l08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3132 {
    public static void main(String[] args) {
        //int[] nums1 = {4,20,16,12,8}, nums2 = {14,18,10};
      //  int[] nums1 = {3,5,5,3}, nums2 = {7,7};
        int[] nums1 = {7,9,1,4}, nums2 = {0,8};
        int i = minimumAddedInteger(nums1, nums2);
        System.out.println(i);
    }

    public static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int t = nums1.length - 2;
        Integer sum1 = Arrays.stream(nums1).boxed().reduce(0, (x, y) -> x + y);
        Integer sum2 = Arrays.stream(nums2).boxed().reduce(0, (x, y) -> x + y);

        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                int v1 = nums1[i];
                int v2 = nums1[j];
                int s = sum1 - v1 - v2;
                int v3 =sum2- s  ;
                if (v3 % t == 0) {
                    int i1 = v3 / t;
                    List<Integer> list =new ArrayList<>();
                    boolean flag =true;
                    for (int k = 0; k < nums1.length; k++) {
                        if(k==i||k==j){
                            continue;
                        }
                        list.add(nums1[k]+i1);
                        if(list.get(list.size()-1)!=nums2[list.size()-1]){
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        return i1;
                    }

                }
            }
        }
        return 0;
    }
}
