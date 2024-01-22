package com.trip.algorithm.leet.l24.l01;

/**
 * @author xbguo
 * @date 2024/1/22 15:03
 */
public class Solution670 {
    public static void main(String[] args) {

    }

    public int maximumSwap(int num) {
        String val = String.valueOf(num);
        int left=0;
        int right=val.length()-1;
        char[] charArray = val.toCharArray();
        while (left<right){
            while (val.charAt(left)=='9'){
                left++;
            }
            for (int i = left+1; i < charArray.length; i++) {
                if(charArray[i]>charArray[left]&&charArray[i]>charArray[right]){
                    right=i;
                }
            }
            break;
        }

        return 0;
    }
}
