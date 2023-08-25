package com.trip.algorithm.leet.leet75.arraystringproblem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年08月22日 22:13:00
 */
public class Solution1431 {
    public static void main(String[] args) {

    }
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=0;
        for (int x:candies){
            max=Math.max(max,x);
        }
        List<Boolean> list = new ArrayList<>();
        for (int x:candies){
            if((x+extraCandies)>=max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}
