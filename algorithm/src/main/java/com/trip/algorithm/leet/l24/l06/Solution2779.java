package com.trip.algorithm.leet.l24.l06;

import java.util.*;

/**
 * @author xbguo
 * @date 2024/6/17 19:46
 * @description TODO
 */
public class Solution2779 {
    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 2};
        int k = 2;

       /* int[] nums = {1,1,1,1};
        int k = 10;*/
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
        linkedList.add(list.get(0));
        int max = 1;
        Queue<Integer> list1 = new PriorityQueue<>((x, y) -> y - x);
        list1.add(l);
        for (int i = 1; i < list.size(); i++) {
            int[] arr = list.get(i);
            int l1 = arr[0];
            int r1 = arr[1];
            int l2 = Math.max(l, l1);
            int r2 = Math.min(r, r1);
            linkedList.add(arr);
            list1.add(l1);

            // 当前没有区间了
            if (l2 > r2) {
                while (!linkedList.isEmpty()) {
                    int[] ints = linkedList.peekFirst();
                    int l3 = Math.max(l1, ints[0]);
                    int r3 = Math.min(r1, ints[1]);
                    if (l3 > r3) {
                        linkedList.pollFirst();
                        list1.remove(ints[0]);
                    } else {
                        l2 = list1.peek();
                        r2 = r3;
                        /*for (int j = 0; j < linkedList.size() - 1; j++) {
                            int[] ints1 = linkedList.get(j);
                            l2 = Math.max(ints1[0], l2);
                            r2 = Math.min(ints1[1], r2);
                        }*/
                        break;
                    }
                }
            }
            max = Math.max(max, linkedList.size());
            l = l2;
            r = r2;
        }

        return max;
    }
}
