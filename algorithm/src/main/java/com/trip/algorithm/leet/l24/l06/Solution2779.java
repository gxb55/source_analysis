package com.trip.algorithm.leet.l24.l06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/6/17 19:46
 * @description TODO
 */
public class Solution2779 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        int i = maximumBeauty(nums, k);
        System.out.println(i);
    }

    public static int maximumBeauty(int[] nums, int k) {
        List<int[]> list = new ArrayList<int[]>();
        for (int a : nums) {
            list.add(new int[]{a - k, a + k});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[1] != o1[1]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        LinkedList<int[]> linkedList = new LinkedList<>();
        int l = list.get(0)[0];
        int r = list.get(0)[1];

        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int[] arr = list.get(i);
            int l1 = arr[0];
            int r1 = arr[1];
            int l2 = Math.max(l, l1);
            int r2 = Math.min(r, r1);
            linkedList.add(arr);
            while (!linkedList.isEmpty()) {
                int[] ints = linkedList.peekFirst();
                if (ints[1] < l2) {
                    linkedList.pollFirst();
                }else {
                    break;
                }
            }
            max = Math.max(max, linkedList.size());
            l = l2;
            r = r2;
        }

        return max;
    }
}
