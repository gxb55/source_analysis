package com.trip.algorithm.leet.some.leet2301;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2023年01月07日 21:16:00
 * 1658. 将 x 减到 0 的最小操作数
 * 给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改 数组以供接下来的操作使用。
 * <p>
 * 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,4,2,3], x = 5
 * 输出：2
 * 解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,6,7,8,9], x = 4
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,20,1,1,3], x = 10
 * 输出：5
 * 解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 * 1 <= x <= 109
 * 通过次数28,682提交次数76,381
 */
public class Solution1658 {
    public static void main(String[] args) {
        Solution1658 solution1658 = new Solution1658();
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
     /*   int[] nums = {5,6,7,8,9};
        int x = 4;*/
       /* int[] nums = {3,2,20,1,1,3};
        int x = 10;*/
        int i = solution1658.minOperations1(nums, x);
        System.out.println(i);
    }

    public int minOperations3(int[] nums, int x) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) {
            return -1;
        }
        int right = 0;
        int lsum = 0, rsum = sum;
        int ans = n + 1;

        for (int left = -1; left < n; ++left) {
            if (left != -1) {
                lsum += nums[left];
            }
            while (right < n && lsum + rsum > x) {
                rsum -= nums[right];
                ++right;
            }
            if (lsum + rsum == x) {
                ans = Math.min(ans, (left + 1) + (n - right));
            }
        }
        return ans > n ? -1 : ans;
    }


    public int minOperations1(int[] nums, int x) {
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum == x) {
            return len;
        } else if (sum < x) {
            return -1;
        }
        int leftIndex = -1;
        int rightIndex = 0;
        int leftSum = 0;
        int rightSum = sum;
        for (; leftIndex < len; leftIndex++) {
            if (leftIndex != -1) {
                leftSum = leftSum + nums[leftIndex];
            }
            while (rightIndex < len && (leftSum + rightSum) > x) {
                rightSum = rightSum - nums[rightIndex];
                rightIndex++;
            }
            if (leftSum + rightSum == x) {
                res = Math.min(res, leftIndex + 1 + (len - rightIndex));
            }
        }
        return res>len?-1:res;
    }


    public int minOperations(int[] nums, int x) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            sum = sum + nums[i];
            left[i] = sum;
            int cur = left[i];
            if (cur == x) {
                res = Math.min(i + 1, res);
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        sum = 0;
        for (int i = length - 1; i >= 0; i--) {
            sum = sum + nums[i];
            right[i] = sum;
            if (right[i] == x) {
                res = Math.min(res, length - i);
            }
            map.put(sum, i);
        }

        for (int i = 0; i < length; i++) {
            int cur = left[i];
            if (cur < x) {
                Integer val = map.get(x - cur);
                if (val != null && val > i) {
                    int res1 = i + 1 + (length - val);
                    res = Math.min(res1, res);
                }
            } else {
                break;
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int process(int cur, int sum, int[] right, int index) {
        if (cur > sum) {
            return -1;
        }
        int leftIndex = index + 1;
        int rightIndex = right.length - 1;
        while (leftIndex <= rightIndex) {
            int mid = leftIndex + (rightIndex - leftIndex) / 2;
            int val = right[mid];
            if (cur + val == sum) {
                return mid;
            }
            if (sum > (cur + val)) {
                rightIndex--;
            } else {
                leftIndex++;
            }
        }
        return -1;
    }
}
