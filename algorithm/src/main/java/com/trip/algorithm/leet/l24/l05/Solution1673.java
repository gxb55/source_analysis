package com.trip.algorithm.leet.l24.l05;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xbguo
 * @date 2024/5/24 14:28
 * @description TODO
 */
public class Solution1673 {

    public static void main(String[] args) {
        Solution1673 solution1673 = new Solution1673();
       /* int[] nums = {3, 5, 2, 6};
        int k = 2;*/

        int[] nums = {2, 4, 3, 3, 5, 4, 9, 6};
        int k = 6;
        int[] ints = solution1673.mostCompetitive1(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public int[] mostCompetitive1(int[] nums, int k) {
        if (k == nums.length) {
            return nums;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while (!queue.isEmpty()&&num<queue.peekLast()&&(queue.size()+(nums.length-i-1))>=k){
                queue.pollLast();
            }
            queue.addLast(num);
        }
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = queue.pollFirst();
        }
        return arr;
    }

    public int[] mostCompetitive(int[] nums, int k) {
        int index = 0;
        List<Integer> list = new ArrayList<>();
        process(index, k, list, nums);
        int[] arr = new int[k];
        for (int i = 0; i < minList.size(); i++) {
            arr[i] = minList.get(i);
        }
        return arr;
    }

    List<Integer> minList = new ArrayList<>();

    private void process(int index, int k, List<Integer> list, int[] nums) {
        if (list.size() == k) {
            if (minList.isEmpty()) {
                minList = new ArrayList<>(list);
            } else {
                for (int i = 0; i < k; i++) {
                    if (minList.get(i) > list.get(i)) {
                        minList = new ArrayList<>(list);
                        break;
                    } else if (minList.get(i) < list.get(i)) {
                        break;
                    }
                }
            }
            System.out.println(JSON.toJSONString(minList) + JSON.toJSONString(list));
            return;
        }
        if (index >= nums.length) {
            return;
        }
        process(index + 1, k, new ArrayList<>(list), nums);
        list.add(nums[index]);
        process(index + 1, k, new ArrayList<>(list), nums);
    }
}
