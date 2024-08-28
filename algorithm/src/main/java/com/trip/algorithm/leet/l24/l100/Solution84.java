package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/8/28 15:25
 * @description TODO
 */
public class Solution84 {
    public static void main(String[] args) {
      //  int[] arr={2,1,5,6,2,3};
        int[] arr={4,2,3};
        int i = largestRectangleArea(arr);
        System.out.println(i);
    }

    public static int largestRectangleArea(int[] heights) {

        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int leftCount = 0;
            int rightCount = 0;
            int r=i;
            for (int j = i - 1; j >= 0; j--) {
                if (height > heights[j]) {
                    break;
                } else {
                    leftCount++;
                }
            }
            boolean flag =true;
            for (int j = i; j < heights.length; j++) {
                if (height > heights[j]) {
                    break;
                } else {
                    rightCount++;
                }
                if(flag){
                    if(height==heights[j]){
                        r=j;
                    }else {
                        flag=false;
                    }
                }
            }
            i=r;
            max = Math.max(((leftCount + rightCount) * height), max);
        }
        return max;
    }
}
