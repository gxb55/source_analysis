package com.trip.algorithm.leet.some.leet2303;

/**
 * @author xbguo
 * @createTime 2023年03月25日 17:08:00
 * 1574. 删除最短的子数组使剩余数组有序
 * 给你一个整数数组 arr ，请你删除一个子数组（可以为空），使得 arr 中剩下的元素是 非递减 的。
 * <p>
 * 一个子数组指的是原数组中连续的一个子序列。
 * <p>
 * 请你返回满足题目要求的最短子数组的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,10,4,2,3,5]
 * 输出：3
 * 解释：我们需要删除的最短子数组是 [10,4,2] ，长度为 3 。剩余元素形成非递减数组 [1,2,3,3,5] 。
 * 另一个正确的解为删除子数组 [3,10,4] 。
 * 示例 2：
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：4
 * 解释：由于数组是严格递减的，我们只能保留一个元素。所以我们需要删除长度为 4 的子数组，要么删除 [5,4,3,2]，要么删除 [4,3,2,1]。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3]
 * 输出：0
 * 解释：数组已经是非递减的了，我们不需要删除任何元素。
 * 示例 4：
 * <p>
 * 输入：arr = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 */
public class Solution1574 {
    public static void main(String[] args) {
         int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
       // int[] arr = {13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20};
        // int[] arr = {1, 2, 3};
        //  int[] arr = {1};
        // int[] arr = {1, 2, 3, 10, 0, 7, 8, 9};
        // int[] arr = {5, 4, 3, 2, 1};
        int val = findLengthOfShortestSubarray(arr);
        System.out.println(val);
    }

    public static int findLengthOfShortestSubarray1(int[] arr) {
        int n = arr.length, j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) {
            return 0;
        }
        int res = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] < arr[i]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return res;
    }

    public static int findLengthOfShortestSubarray(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return 0;
        }
        int res = length;
        int left = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] < arr[i - 1]) {
                left = i;
                break;
            }
        }
        left--;
        if (left >= length) {
            return 0;
        }
        res = Math.min(res, length - left + 1);
        int right = length - 2;
        for (; right >= 0; right--) {
            if (arr[right] > arr[right + 1]) {
                break;
            }
        }
        right++;
        res = Math.min(res,  right );
        for (int i = 0; i <= left; i++) {
            int j = right;
            for (; j < length; j++) {
                if (arr[j] >= arr[i]) {
                    break;
                }
            }
            res = Math.min(res, j - i-1);
        }
        return res;
    }
}
