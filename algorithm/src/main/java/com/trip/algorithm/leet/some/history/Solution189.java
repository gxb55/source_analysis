package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年06月12日 16:16:00
 * 189. 轮转数组
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * 通过次数512,256提交次数1,154,596
 */
public class Solution189 {
    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        /*int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;*/

        int[] nums = {-1,-100,3,99};
        int k = 2;
        solution189.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        boolean[] vis = new boolean[len];
        for (int i = 0; i < len; i++) {
            if(vis[i]){
                continue;
            }
            int cur = i;
            int next = (cur + k) % len;
            int lastVal = nums[cur];
            while (cur != next) {
                vis[next]=true;
                int nextVal = nums[next];
                nums[next] = lastVal;
                lastVal = nextVal;
                next = (next + k) % len;
            }
            nums[cur] = lastVal;
            vis[cur]=true;
        }


    }
}
