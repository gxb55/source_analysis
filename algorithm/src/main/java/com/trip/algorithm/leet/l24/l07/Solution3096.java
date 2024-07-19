package com.trip.algorithm.leet.l24.l07;

/**
 * @author xbguo
 * @date 2024/7/19 10:15
 */
public class Solution3096 {

    public static void main(String[] args) {
        int[] arr={1,1};
        int i = Solution3096.minimumLevels(arr);
        System.out.println(i);
    }

    /**
     * 些关卡是 困难 模式，其他的关卡是 简单 模式。如果 possible[i] == 0 ，那么第 i 个关卡是 困难 模式
     * @param possible
     * @return
     */
    public static int minimumLevels(int[] possible) {
        int right = 0;
        int left = 0;
        for (int i = 0; i < possible.length; i++) {
            if (possible[i] == 0) {
                right--;
            } else {
                right++;
            }
        }
   
        for (int i = 0; i < possible.length; i++) {
            if (possible[i] == 0) {
                left--;
                right++;
            } else {
                left++;
                right--;
            }
            if (left > right) {
                if(i==possible.length-1){
                    return -1;
                }
                return i+1;
            }
        }
        return -1;
    }
}
