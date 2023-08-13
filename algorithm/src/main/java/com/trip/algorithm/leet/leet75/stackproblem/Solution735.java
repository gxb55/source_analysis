package com.trip.algorithm.leet.leet75.stackproblem;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author xbguo
 * @createTime 2023年08月13日 16:20:00
 */
public class Solution735 {
    public static void main(String[] args) {
        //  int[] arr = {5, 10, -5};
        // int[] arr = {8,-8};
          int[] arr = {10,2,-5};
        //  int[] arr = {-2,-1,1,2};
       // int[] arr = {-2, -2, 1, -2};
        int[] ints = asteroidCollision(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid < 0 && !deque.isEmpty() && deque.peekLast() > 0) {
                boolean flag = false;
                while (!deque.isEmpty()) {
                    Integer peek = deque.peekLast();
                    if (peek > 0) {
                        if (peek > Math.abs(asteroid)) {
                            flag = false;
                            break;
                        } else if (peek == Math.abs(asteroid)) {
                            deque.pollLast();
                            flag = false;
                            break;
                        } else {
                            flag = true;
                            deque.pollLast();
                        }
                    } else {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    deque.addLast(asteroid);
                }
            } else {
                deque.addLast(asteroid);
            }
        }
        int[] res = new int[deque.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = deque.pollFirst();
        }
        return res;
    }
}
