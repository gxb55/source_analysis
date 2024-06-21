package com.trip.algorithm.leet.l24.l06;

/**
 * @author xbguo
 * @date 2024/6/20 15:02
 * @description TODO
 */
public class Solution2748 {
    public static void main(String[] args) {

    }

    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int num1 = nums[j];
                boolean flag = check(String.valueOf(num), String.valueOf(num1));
                if (flag) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean check(String s, String s1) {
        int a = s.charAt(0) - '0';
        int b = s1.charAt(s1.length() - 1) - '0';
        for (int i = 2; i < 10; i++) {
            if(i>a||i>b){
                return true;
            }
            if(a%i==0&&b%i==0){
                return false;
            }
        }
        return true;
    }
}
