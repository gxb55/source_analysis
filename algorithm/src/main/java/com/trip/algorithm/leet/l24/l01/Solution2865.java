package com.trip.algorithm.leet.l24.l01;

import java.util.Arrays;
import java.util.List;

public class Solution2865 {
    public static void main(String[] args) {
        Solution2865 solution2865 = new Solution2865();
    //    List<Integer> maxHeights = Arrays.asList(5, 3, 4, 1, 1);
        List<Integer> maxHeights = Arrays.asList(6,5,3,9,2,7);
        long l = solution2865.maximumSumOfHeights1(maxHeights);
        System.out.println(l);
    }

    public long maximumSumOfHeights1(List<Integer> maxHeights) {
        int size = maxHeights.size();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            int cur = maxHeights.get(i);
            int leftCur = maxHeights.get(i);
            int rightCur = maxHeights.get(i);
            int l = i - 1;
            int r = i  +1;
            long leftSum = 0;
            long rightSum = 0;
            while (l >= 0) {
                if (maxHeights.get(l) < leftCur) {
                    leftCur = maxHeights.get(l);
                }
                leftSum += leftCur;
                l--;
            }
            while (r < size) {
                if (maxHeights.get(r) < rightCur) {
                    rightCur = maxHeights.get(r);
                }
                rightSum += rightCur;
                r++;
            }
            sum = Math.max(sum, leftSum + cur + rightSum);
        }
        return sum;
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long[] left = new long[maxHeights.size()];
        long[] leftArr = new long[maxHeights.size()];
        long[] right = new long[maxHeights.size()];
        long[] rightArr = new long[maxHeights.size()];
        int size = maxHeights.size();
        long leftSum = 0;
        long rightSum = 0;
        // 从左到右降序
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                left[i] = maxHeights.get(i);
            } else {
                Integer val = maxHeights.get(i);
                if (left[i - 1] > val) {
                    left[i] = val;
                } else {
                    left[i] = left[i - 1];
                }
            }
            leftSum += left[i];
            leftArr[i] = leftSum;
        }
        // 从右到左降序
        for (int i = size - 1; i >= 0; i--) {
            if (i == (size - 1)) {
                right[i] = maxHeights.get(i);
            } else {
                Integer val = maxHeights.get(i);
                if (val > right[i + 1]) {
                    right[i] = right[i + 1];
                } else {
                    right[i] = val;
                }
            }
            rightSum += right[i];
            rightArr[i] = rightSum;
        }
        long max = Math.max(leftSum, rightSum);
        for (int i = 1; i < size - 1; i++) {
            long t = leftArr[i - 1] + rightArr[i + 1] + maxHeights.get(i);
            max = Math.max(max, t);
        }
        return max;
    }
}
