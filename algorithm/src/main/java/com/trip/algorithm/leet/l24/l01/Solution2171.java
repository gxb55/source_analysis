package com.trip.algorithm.leet.l24.l01;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2024/1/18 14:32
 */
public class Solution2171 {
    public static void main(String[] args) {
        Solution2171 solution2171 = new Solution2171();
        int[] beans = {4, 1, 6, 5};
        long l = solution2171.minimumRemoval(beans);
        System.out.println(l);
    }

    public long minimumRemoval(int[] beans) {
        long left = 0;
        long right = Arrays.stream(beans).max().getAsInt();
        while (left < right) {
            long mid = left + (right - left) / 2;
            Long leftRes = getRes(left, beans);
            Long midRes = getRes(mid, beans);
            Long rightRes = getRes(right, beans);

            if (rightRes > midRes && midRes > leftRes) {
                right = mid - 1;
            }
            if (leftRes > midRes && midRes > rightRes) {
                left = mid + 1;
            }
            if (midRes < leftRes && midRes < rightRes) {
                if (leftRes < rightRes) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
        return getRes(left, beans);
    }

    private Long getRes(long left, int[] beans) {
        long sum = 0;
        for (int k : beans) {
            if (k < left) {
                sum += k;
            } else {
                sum += (k - left);
            }
        }
        return sum;
    }
}
