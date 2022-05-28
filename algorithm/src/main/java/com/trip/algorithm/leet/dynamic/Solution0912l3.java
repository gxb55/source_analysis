package com.trip.algorithm.leet.dynamic;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * <p>
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * <p>
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 * 通过次数47,652提交次数75,686
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-and-earn
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution0912l3 {
    public static void main(String[] args) {
        Solution0912l3 solution0912l3 = new Solution0912l3();
        int arr[] = {8,10,4,9,1,3,5,9,4,10};
        int i = solution0912l3.deleteAndEarn(arr);
        System.out.println(i);
    }

    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return getMaxValue(nums);
    }

    public int deleteAndEarn1(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }


    /**
     * 2, 2, 3, 3, 3, 4
     *
     * @param nums
     * @return
     */
    public int getMaxValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }


        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        // 元素转化为元素对应的下标，这样比如 2-》在dp[2]的位置
        //3->dp[3] 然后把重复的值相加，即多少个3个2那就是dp[2]=6
        int[] newArr = new int[max + 1];
        for (int i : nums) {
            newArr[i] = newArr[i] + i;
        }
        int dp[] = new int[newArr.length + 1];
        dp[0] = newArr[0];
        dp[1] = Math.max(newArr[0], newArr[1]);
        for (int i = 2; i < newArr.length; i++) {
            dp[i] = dp[i - 2] + newArr[i];
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    private int getResult(int[] nums, int i) {

        return 0;
    }

    private int getIndex(int[] newNums, int i) {
        for (int j = i + 1; j < newNums.length; j++) {
            if (newNums[j] != -1) {
                return j;
            }
        }
        return -1;
    }

    private int[] handleNums(int[] nums, int i) {
        int x = nums[i];
        int y = x - 1;
        int z = x + 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == y || nums[j] == z) {
                nums[j] = -1;
            }
        }
        return nums;
    }
}
