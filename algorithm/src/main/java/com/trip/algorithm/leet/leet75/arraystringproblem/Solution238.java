package com.trip.algorithm.leet.leet75.arraystringproblem;

/**
 * @author xbguo
 * @date 2023/8/21 20:52
 */
public class Solution238 {
    public static void main(String[] args) {

    }
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left =new int[len];
        int[] right =new int[len];
        int[] res =new int[len];
        int cur=1;
        for (int i = 0; i < len; i++) {
            cur*=nums[i];
            left[i]=cur;
        }
         cur=1;
        for (int i = len-1; i >=0; i--) {
            cur*=nums[i];
            right[i]=cur;
        }
        for (int i = 0; i < len; i++) {
            if(i==0){
                res[i]=right[i+1];
            }else if(i==len-1){
                res[i]=left[i-1];
            }else{
                res[i]=left[i-1]*right[i+1];
            }
        }
        return res;
    }
}
