package com.trip.algorithm.leet.l24.l100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Solution215 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] arr = {3, 2, 1, 5, 6, 4};
        int t = 4;

       /* int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int t = 3;*/

       /* int[] arr = {-1, 2, 0};
        int t = 1;
*/
        int kthLargest = solution215.findKthLargest1(arr, t);
        System.out.println(kthLargest);
    }

    public int findKthLargest(int[] nums, int k) {
        return find(nums, k - 1, 0, nums.length - 1);
    }

    private int find(int[] nums, int k, int left, int right) {

        // 从大到小，降序，然后找前几个就可了
        int l = left;
        int r = right;
        int midIndex = new Random().nextInt(right);
        while (midIndex < left) {
            midIndex = new Random().nextInt(right);
        }
        System.out.println(left + ":" + midIndex + ":" + r);
        int mid = nums[midIndex];
        while (l < r) {
            while (l < r && nums[r] <= mid) {
                r--;
            }
            while (l < r && nums[l] >= mid) {
                l++;
            }

            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        nums[left] = nums[midIndex];
        nums[midIndex] = mid;

        if (k < (l)) {
            return find(nums, k, left, l - 1);
        } else if (k > (l)) {
            return find(nums, k, l + 1, right);
        } else {
            return nums[l];
        }
    }

    public int findKthLargest1(int[] nums, int k) {
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());

        return process1(collect, k);
    }

    private int process1(List<Integer> nums, int k) {
        int midIndex = new Random().nextInt(nums.size());
        List<Integer> big = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> small = new ArrayList<>();
        int pivot=nums.get(midIndex);
        for (int num : nums) {
            if (num > pivot) {
                big.add(num);
            } else if (num < pivot) {
                small.add(num);
            } else {
                equal.add(num);
            }
        }
        if(big.size()>=k){
            return process1(big, k);
        }
        if((equal.size()+big.size())>=k){
            return pivot;
        }
        return process1(small, k - big.size() - equal.size());
    }

    private static int process(int[] nums, int left, int right, int k) {
        int val = nums[left];
        int curLeft = left;
        int curRight = right;
        while (curRight > curLeft) {
            // 从大到小，先从小的获取
            while (curRight > curLeft && nums[curRight] <= val) {
                curRight--;
            }
            while (curRight > curLeft && nums[curLeft] >= val) {
                curLeft++;
            }
            if (curRight > curLeft) {
                int t = nums[curRight];
                nums[curRight] = nums[curLeft];
                nums[curLeft] = t;
            }
        }
        nums[left] = nums[curRight];
        nums[curRight] = val;
        if (curLeft + 1 == k) {
            return nums[curLeft];
        }
        if (curLeft + 1 > k) {
            return process(nums, left, curLeft - 1, k);
        } else {
            return process(nums, curRight + 1, right, k);
        }
    }
}
