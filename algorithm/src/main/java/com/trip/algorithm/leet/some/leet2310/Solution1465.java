package com.trip.algorithm.leet.some.leet2310;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2023/10/27 10:45
 */
public class Solution1465 {
    public static void main(String[] args) {
      /*  int h = 5, w = 4;
        int[] horizontalCuts = {3,1}, verticalCuts = {1}; */

      /*  int h = 5, w = 4;
        int[] horizontalCuts = {1,2,4}, verticalCuts = {1,3};*/

       /* int h = 1000000000, w = 1000000000;
        int[] horizontalCuts = {2}, verticalCuts = {2};*/

        int h = 1000000000, w = 1000000000;
        int[] horizontalCuts = {1,999999999}, verticalCuts = {1,999999999};

        Solution1465 solution1465 = new Solution1465();
        int i = solution1465.maxArea1(h, w, horizontalCuts, verticalCuts);
        System.out.println(i);
    }

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        //水平切口
        Arrays.sort(horizontalCuts);
        List<Integer> list1 = new ArrayList<>();
        Arrays.stream(horizontalCuts).forEach(x -> list1.add(x));
        if (list1.get(list1.size() - 1) != h) {
            list1.add(h);
        }
        //竖直切口
        Arrays.sort(verticalCuts);
        List<Integer> list2 = new ArrayList<>();
        Arrays.stream(verticalCuts).forEach(x -> list2.add(x));
        if (list2.get(list2.size() - 1) != w) {
            list2.add(w);
        }
        long mod = 1000000007;
        int lastX = 0;
        int lastY = 0;
        BigInteger max = BigInteger.ZERO;
        for (int i = 0; i < list2.size(); i++) {
            long v2 = list2.get(i) - lastY;
            lastX = 0;
            for (int j = 0; j < list1.size(); j++) {
                int horizontalCut = list1.get(j);
                long v1 = horizontalCut - lastX;

                v1 = v1 % mod;
                v2 = v2 % mod;
                BigInteger curVal =BigInteger.valueOf(v1).multiply(BigInteger.valueOf(v2));
                int x = curVal.compareTo(max);
                if(x>0){
                    max=curVal;
                }
                lastX = horizontalCut;
            }
            lastY = list2.get(i);
        }
         max = max.mod(BigInteger.valueOf(mod));
        return  max.intValue();
    }

    public int maxArea1(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        List<Integer> list1 = Arrays.stream(horizontalCuts).boxed().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(verticalCuts).boxed().collect(Collectors.toList());
        if(!list1.contains(0)){
            list1.add(0);
        }
        if(!list1.contains(h)){
            list1.add(h);
        }
        if(!list2.contains(0)){
            list2.add(0);
        }
        if(!list2.contains(w)){
            list2.add(w);
        }
        list1.sort((x,y)->x-y);
        list2.sort((x,y)->x-y);
        long x=0;
        long mod = 1000000007;
        for (int i = 1; i < list1.size(); i++) {
            int v = list1.get(i) - list1.get(i - 1);
            x= Math.max(x,v);
        }
        long y=0;
        for (int i = 1; i < list2.size(); i++) {
            int v = list2.get(i) - list2.get(i - 1);
            y= Math.max(y,v);
        }
        BigInteger curVal =BigInteger.valueOf(x).multiply(BigInteger.valueOf(y));
        curVal = curVal.mod(BigInteger.valueOf(mod));
        return curVal.intValue();
    }
}
