package com.trip.algorithm.leet.l24.l05;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/5/16 19:31
 * @description TODO
 */
public class Solution1953 {

    public static void main(String[] args) {
      //  int[] milestones = {1,2,3};
      //  int[] milestones = {5,2,1,8};
        int[] milestones = {9,3,6,8,2,1};
        long l = numberOfWeeks(milestones);
        System.out.println(l);
    }

    public static long numberOfWeeks(int[] milestones) {
        Arrays.sort(milestones);
        int count = 0;
        int last = -1;
        int left = 0;
        int right = milestones.length - 1;
        while (true) {
            while (left<milestones.length&&milestones[left] == 0) {
                left++;
            }
            while (right>=0&&milestones[right] == 0) {
                right--;
            }
            if(left>right){
                break;
            }
            if (last == right) {
                break;
            }
            if(left==right){
                milestones[right]--;
                count++;
                last=left;
                continue;
            }
            milestones[right]--;
            count++;
            milestones[left]--;
            count++;
            last=left;
        }
        return count;
    }

}
