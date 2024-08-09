package com.trip.algorithm.leet.l24.l08;

import java.util.LinkedList;

/**
 * @author xbguo
 * @date 2024/8/6 14:49
 */
public class Solution3129 {
    public static void main(String[] args) {
        Solution3129 solution3129 = new Solution3129();
        // int zero = 1, one = 1, limit = 2;
        int zero = 3, one = 3, limit = 2;
        int i = solution3129.numberOfStableArrays(zero, one, limit);
        System.out.println(i);
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        LinkedList<Integer> list = new LinkedList<>();
        process(zero, one, limit, list);
        return (int) count;
    }

    private void process(int zero, int one, int limit, LinkedList<Integer> list) {
        if (zero < 0 || one < 0) {
            return;
        }
        if (!check(limit, list)) {
            return;
        }
        if (zero == 0 && one == 0) {
            System.out.println(list);
            count++;
            count = count % 1000000007;
            return;
        }
        for (int i = 0; i <= 1; i++) {
            list.addLast(i);
            if (i == 0) {
                process(zero - 1, one, limit, list);
            } else {
                process(zero, one - 1, limit, list);
            }
            list.pollLast();
        }


    }

    private boolean check(int limit, LinkedList<Integer> list) {
        if (limit+1 > list.size()) {
            return true;
        }
        int t = limit;
        boolean flag0 = false;
        boolean flag1 = false;
        for (int i = list.size() - 1; i >= 0 && t >= 0; i--, t--) {
            Integer integer = list.get(i);
            if (integer == 1) {
                flag1 = true;
            } else if (integer == 0) {
                flag0 = true;
            }
            if (flag0 && flag1) {
                break;
            }
        }
        return flag0 && flag1;
    }


    long count = 0;
}
