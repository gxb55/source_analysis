package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/1/14  13:51
 * @description 373. 查找和最小的 K 对数字
 * 373. 查找和最小的 K 对数字
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [1,1],[1,1]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 示例 3:
 * <p>
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [1,3],[2,3]
 * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 和 nums2 均为升序排列
 * 1 <= k <= 1000
 * 通过次数28,535提交次数69,305
 */
public class Solution373 {
    public static void main(String[] args) {

      /*  int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;*/
        int[] nums1 = {1, 2, 4, 5, 6};
        int[] nums2 = {3, 5, 7, 9};
        int k = 8;


        Solution373 solution373 = new Solution373();
        List<List<Integer>> list = solution373.kSmallestPairs(nums1, nums2, k);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return null;
        }
        List<List<Integer>> smallestPairs = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (a, b) -> (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]));
        // 1. 维护 K 个元素到堆中 : (i, 0)
        for (int i = 0; i < Math.min(n, k); i++) {
            queue.add(new int[]{i, 0});
        }
        // 2. 取出堆顶元素并加入新元素
        while (k > 0 && !queue.isEmpty()) {
            int[] pairs = queue.poll();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[pairs[0]]);
            list.add(nums2[pairs[1]]);
            smallestPairs.add(list);
            if (pairs[1] + 1 < m) {
                queue.add(new int[]{pairs[0], pairs[1] + 1});
            }
            k--;
        }
        return smallestPairs;

    }


    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (k > length1 * length2) {
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            for (Integer i : nums1) {
                for (Integer j : nums2) {
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    list1.add(j);
                    list.add(list1);
                }
            }
            return list.stream().sorted((x, y) -> {
                Integer val = x.stream().mapToInt(z -> Integer.valueOf(z)).sum();
                Integer val1 = y.stream().mapToInt(z -> Integer.valueOf(z)).sum();
                return val.compareTo(val1);
            }).collect(Collectors.toList());
        } else {
            int left = 0;
            int right = 0;
            List<List<Integer>> list = new ArrayList<List<Integer>>();
            while (left < length1 && right < length2 && left >= 0 && right >= 0 && list.size() < k) {
                List<Integer> innerList = new ArrayList<>();
                innerList.add(nums1[left]);
                innerList.add(nums2[right]);
                list.add(innerList);
                if (left + 1 < length1 && right + 1 < length2) {
                    if (nums1[left] + nums2[right + 1] > nums1[left + 1] + nums2[right]) {
                        left++;
                    } else {
                        right++;
                    }
                } else if (left + 1 > length1) {
                    right++;
                } else if (right + 1 > length2) {
                    left++;
                }
            }
            return list;
        }

    }
}
