package com.trip.algorithm.leet.some.leet08;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @date 2022/8/26  10:06
 * @description Solution1464
 */
public class Solution1464 {
    public static void main(String[] args) {
        Solution1464 solution1464 = new Solution1464();
        int[] arr={1,2,3,4,5,6};
        int i = solution1464.maxProduct(arr);
        System.out.println(i);
    }
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->x.compareTo(y));
        int k=2;
        for (int i:nums){
            if(queue.size()<k){
                queue.add(i);
            }else{
                if(queue.peek()<i){
                    queue.poll();
                    queue.add(i);
                }
            }
        }
        return (queue.poll()-1)*(queue.poll()-1);
    }
}
