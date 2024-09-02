package com.trip.algorithm.leet.l24.l09;

import java.util.Objects;

/**
 * @author xbguo
 * @date 2024/9/2 20:27
 * @description TODO
 */
public class Solution2024 {
    public static void main(String[] args) {
       /*String answerKey = "TTFF";
       int k = 2;*/

     /*  String answerKey = "TTFTTFTT";
       int k = 1;   */

     /*  String answerKey = "TTFF";
       int k = 2;*/
       String answerKey = "TF";
       int k = 2;
        int i = maxConsecutiveAnswers(answerKey, k);
        System.out.println(i);
    }

    public static int maxConsecutiveAnswers(String answerKey, int k) {
        char[] charArray = answerKey.toCharArray();
        int p1 = getResult(charArray, k, 'T');
        int p2 = getResult(charArray, k, 'F');
        return Math.max(p1, p2);
    }

    private static int getResult(char[] charArray, int k, Character t) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < charArray.length) {
            while (k >= 0&&right<charArray.length) {
                if (!Objects.equals(t,charArray[right])) {
                    k--;
                }
                right++;
            }
            if(k>=0){
                max = Math.max(right - left, max);
            }else {
                max = Math.max(right - left-1, max);
            }

            while (k<0&&left<right){
                if (!Objects.equals(t,charArray[left])) {
                    k++;
                }
                left++;
            }
        }
        return max;
    }
}
