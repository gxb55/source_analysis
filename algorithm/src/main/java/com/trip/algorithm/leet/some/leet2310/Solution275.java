package com.trip.algorithm.leet.some.leet2310;

/**
 * @author xbguo
 * @date 2023/10/30 11:05
 */
public class Solution275 {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 3, 5, 6};
        //int[] arr = {1,2,100};
       // int[] arr = {0, 1};
       // int[] arr = {11,15};
        int[] arr = {0,0,4,4};
        int i = hIndex(arr);
        System.out.println(i);
    }

    public static int hIndex(int[] citations) {

        int left = 0;
        int res = -1;
        int right = citations.length - 1;
        int len = citations.length;
        if (len == 1) {
            return citations[0] > 0 ? 1 : 0;
        }
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            // 当前的值是多少
            int val = citations[mid];
            // 有多个值是大于val的
            int curLen = len - mid;
            if (curLen >= val) {
                res = val;
            }
            if (curLen >= val) {
                left = left + 1;
            } else {
                right = right - 1;

            }
        }
        if(res==-1){
            if(citations[0]>len){
                return len;
            }
        }
        return res == -1 ? 0 : res;
    }
}
