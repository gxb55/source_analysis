package com.trip.algorithm.leet.leet75.binarylookupproblem;

/**
 * @author xbguo
 * @createTime 2023年09月02日 14:51:00
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 */
public class Solution374 {
    public static void main(String[] args) {
        Solution374 solution374 = new Solution374();
        int n = 1;
        int i = solution374.guessNumber(n);
        System.out.println(i);
    }

    public int guessNumber(int n) {
        int left = 0;
        int right = n+1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return mid;
    }

    public int guessNumber1(int n) {
        int left=0;
        int right=n;
        while(left<right){
            int mid = left+(right-left)/2;
            int v=guess(mid);
            if(v==0){
                return mid;
            }else if(v<0){
                right=mid;
            }else if(v>0){
                left=mid+1;
            }
        }
        return n;
    }

    private int guess(int mid) {
        if (mid == 1) {
            return 0;
        }
        return mid > 1 ? 1 : -1;
    }
}
