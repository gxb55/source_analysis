package com.trip.algorithm.leet.some.leet10;

/**
 * @auther: xbguo
 * @date: 2022/10/27 09:56
 * @description: Solution1822
 */
public class Solution1822 {
    public int arraySign(int[] nums) {
        int f=0;
        for(int x:nums){
           if(x==0){
               return 0;
           }else if(x<0){
               f++;
           }
        }
        if(f==0){
            return 1;
        }
        if(f%2==0){
            return 1;
        }else{
            return -1;
        }

    }

    public static void main(String[] args) {
        int[] arr={41,65,14,80,20,10,55,58,24,56,28,86,-96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41};
        Solution1822 solution1822 = new Solution1822();
        int i = solution1822.arraySign(arr);
        System.out.println(i);
    }
}
