package com.trip.algorithm.leet.some.leet2301;


/**
 * @author xbguo
 * @date 2023/1/4 09:49
 * @description solution1802
 * 输入：n = 4, index = 2,  maxSum = 6
 * 输出：2
 * 解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
 * 示例 2：
 * <p>
 * 输入：n = 6, index = 1,  maxSum = 10
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-value-at-a-given-index-in-a-bounded-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1802 {
    public static void main(String[] args) {
        Solution1802 solution1802 = new Solution1802();
        int n = 4, index = 2, maxSum = 6;
        // int n = 6, index = 1,  maxSum = 10;

        //  int n = 4, index = 0, maxSum = 4;
        //   int n = 1, index = 0, maxSum = 24;
        int i = solution1802.maxValue3(n, index, maxSum);
        System.out.println(i);
    }

    public int maxValue(int n, int index, int maxSum) {
        int res=maxSum-n;
        int leftIndex=index-1;
        int rightIndex=index+1;


        return 0;
    }

    public int maxValue1(int n, int index, int maxSum) {
        int right = maxSum;
        int left = 0;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean flag = check(mid, n, index, maxSum);
            if (flag) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    private boolean check(int mid, int n, int index, int maxSum) {
        int left = index - 1;
        int right = index + 1;
        int leftMid = mid;
        while (left >= 0 && maxSum >= 0) {
            left--;
            if (leftMid == 1) {

            } else {
                leftMid--;
            }
            maxSum = maxSum - leftMid;

        }
        int rightMid = mid;
        while (right < n && maxSum > 0) {
            right++;
            if (rightMid == 1) {

            } else {
                rightMid--;
            }
            maxSum = maxSum - rightMid;
        }
        if (left < 0 && right >= n && maxSum >= 0) {
            return true;
        }
        return false;
    }

    public int maxValue3(int n, int index, int maxSum) {
        int left = 1, right = maxSum;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (valid(mid, n, index, maxSum)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public boolean valid(int mid, int n, int index, int maxSum) {
        int left = index;
        int right = n - index - 1;
        return mid + cal(mid, left) + cal(mid, right) <= maxSum;
    }

    public long cal(int big, int length) {
        if (length + 1 < big) {
            int small = big - length;
            return (long) (big - 1 + small) * length / 2;
        } else {
            int ones = length - (big - 1);
            return (long) big * (big - 1) / 2 + ones;
        }
    }

    public int maxValue4(int n, int index, int maxSum) {
        int lCount = index, rCount = n - 1 - index; // 山峰左右两侧的元素数量
        int l = 1, r = maxSum; // 二分查找的左右边界
        while(l <= r){
            int m = (l + r)/2;
            long sum = m + helper(m, lCount) + helper(m, rCount);
            if(sum > maxSum)r = --m;
            else l = ++m;
        }
        return l - 1; // 此时，l 代表数组和恰好大于 maxSum 时的数组和。
    }

    /*求山峰一侧的元素的和，max 为山峰大小，k 为某一侧的元素数量*/
    private long helper(int max, int k){
        if(max > k) {
            return (long)k * (2 * max - 1 - k) / 2;
        } else {
            return (long)(max - 3) * max / 2 + k + 1;
        }
    }


}
