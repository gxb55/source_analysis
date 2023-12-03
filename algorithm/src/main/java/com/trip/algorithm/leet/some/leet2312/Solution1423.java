package com.trip.algorithm.leet.some.leet2312;

import java.util.ArrayList;
import java.util.List;

public class Solution1423 {
    public static void main(String[] args) {
        Solution1423 solution1423 = new Solution1423();
     /*   int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3; */

       /* int[] cardPoints = {1,79,80,1,1,1,200,1};
        int k = 3;*/

        int[] cardPoints = {11,49,100,20,86,29,72};
        int k = 4;
        int i = solution1423.maxScore(cardPoints, k);
        System.out.println(i);
    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
            list1.add(sum);
        }
        sum = 0;
        for (int i = cardPoints.length - 1; i >= 0 && k > 0; i--, k--) {
            sum += cardPoints[i];
            list2.add(sum);
        }
        if (list1.size() == cardPoints.length) {
            return list1.get(list1.size() - 1);
        }
        int max = list1.get(list1.size() - 1);
        max = Math.max(max, list2.get(list1.size() - 1));
        for (int i = 0; i < list1.size(); i++) {
            if (i == 0) {
                int index2 = list1.size() - i - 1;
                max = Math.max(list2.get(index2), max);
            }else {
                int index1 = i - 1;
                int index2 = list1.size() - i - 1;
                Integer v1 = list1.get(index1);
                Integer v2 = list2.get(index2);
                max = Math.max(v1 + v2, max);
            }


        }
        return max;
    }
}
