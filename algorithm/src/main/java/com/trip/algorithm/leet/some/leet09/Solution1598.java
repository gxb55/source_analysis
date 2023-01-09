package com.trip.algorithm.leet.some.leet09;

/**
 * @author xbguo
 * @date 2022/9/9  9:49
 * @description Solution1598
 */
public class Solution1598 {
    public static void main(String[] args) {
        Solution1598 solution1598 = new Solution1598();
       // String[] logs = {"d1/","d2/","../","d21/","./"};
       // String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
        String[] logs = {"d1/","../","../","../"};
        int i = solution1598.minOperations(logs);
        System.out.println(i);
    }

    public int minOperations(String[] logs) {
        int count = 0;
        for (int i = 0; i < logs.length; i++) {
            String log = logs[i];
            if (log.equals("../")) {
                count++;
                if (count > 0) {
                    count = 0;
                }
            } else if (log.equals("./")) {

            } else {
                count--;
            }
        }
        return Math.abs(count);
    }
}
