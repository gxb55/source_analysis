package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/9/13 16:49
 */
public class Solution74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] res=null;
        for (int[] arr:matrix){
            int min = arr[0];
            int max = arr[arr.length-1];
            if(target>=min&&target<=max){
                res=arr;
                break;
            }
        }
        if(res==null){
            return false;
        }
        int l=0;
        int r=res.length-1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int midVal = res[mid];
            if (target > midVal) {
                l = mid + 1;
            } else if (target < midVal) {
                r = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
