package com.trip.algorithm.leet.l24.l03;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution331 {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        Solution331 solution331 = new Solution331();
        boolean validSerialization = solution331.isValidSerialization(preorder);
        System.out.println(validSerialization);
    }

    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        for (int i = 0; i < split.length; i++) {
            String val = split[i];
            if (val.equals(",")) {
                continue;
            } else if (val.equals("#")) {
                if (deque.isEmpty()) {
                    return false;
                }
                Integer pop = deque.pop();
                pop -= 1;
                if (pop > 0) {
                    deque.push(pop);
                }

            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                Integer pop = deque.pop();
                pop -= 1;
                if (pop > 0) {
                    deque.push(pop);
                }
                deque.push(2);
            }
        }
        return deque.isEmpty();
    }
}
