package com.trip.algorithm.leet.l24.l100;

/**
 * @author xbguo
 * @date 2024/8/9 16:57
 */
public class Solution75 {
    public static void main(String[] args) {

    }

    public void sortColors(int[] nums) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num==0){
                x++;
            }else if(num==1){
                y++;
            }else {
              z++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(x>0){
                x--;
                nums[i]=0;
            }else if(y>0){
                y--;
                nums[i]=1;
            }else {
                nums[i]=2;
            }
        }
    }

}
