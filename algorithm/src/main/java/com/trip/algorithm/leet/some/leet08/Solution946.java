package com.trip.algorithm.leet.some.leet08;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2022/8/31  15:24
 * @description Solution946
 */
public class Solution946 {
    public static void main(String[] args) {
        Solution946 solution946 = new Solution946();
       /* int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};*/

        int[] pushed = {2, 1, 3, 0};
        int[] popped = {1, 0, 3, 2};

       /* int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};*/
     /*   int[] pushed = {0, 2, 1};
        int[] popped = {0, 1, 2};*/
        boolean b = solution946.validateStackSequences(pushed, popped);
        System.out.println(b);
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> leftQueue = new LinkedList<>();
        LinkedList<Integer> rightQueue = new LinkedList<>();
        for (int i = 0; i < popped.length; i++) {
            int val = popped[i];
            if (i == 0) {
                boolean flag = true;
                for (int j = 0; j < pushed.length; j++) {
                    int p = pushed[j];
                    if (p == val) {
                        flag = false;
                    }
                    if (flag) {
                        leftQueue.addLast(p);
                    } else {
                        rightQueue.addLast(p);
                    }
                }
            }
            if (!leftQueue.isEmpty() && val == leftQueue.peekLast()) {
                leftQueue.pollLast();
            } else if (!rightQueue.isEmpty() && val == rightQueue.peekFirst()) {
                rightQueue.pollFirst();
            }  else if (!rightQueue.isEmpty() && leftQueue.isEmpty()) {
                while (!rightQueue.isEmpty()) {
                    if (rightQueue.peekFirst() == val) {
                        rightQueue.pollFirst();
                        break;
                    }
                    leftQueue.addLast(rightQueue.pollFirst());
                }
            }else if (!rightQueue.isEmpty() && !leftQueue.isEmpty()) {
                while (!rightQueue.isEmpty()) {
                    if (rightQueue.peekFirst() == val) {
                        rightQueue.pollFirst();
                        break;
                    }
                    leftQueue.addLast(rightQueue.pollFirst());
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
