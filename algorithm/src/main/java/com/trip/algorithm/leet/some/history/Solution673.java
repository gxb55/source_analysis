package com.trip.algorithm.leet.some.history;

import java.util.Arrays;

/**
 * @author xbguo
 * @createTime 2022年06月04日 22:29:00
 * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
 * <p>
 * 注意 这个数列必须是 严格 递增的。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 *  
 * <p>
 * 提示: 
 * <p>
 * 1 <= nums.length <= 2000
 * -106 <= nums[i] <= 106
 * 通过次数64,933提交次数147,094
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution673 {
    public static void main(String[] args) {
        Solution673 solution673 = new Solution673();
        // int[] arr = {1, 3, 5, 4, 7};
        //int[] arr = {5, 5, 5, 5, 5};
        //[1,2,4,3,5,4,7,2]
        // int[] arr = {1, 2, 4, 3, 5, 4, 7, 2};
        // int[] arr = {1, 2, 4, 3, 5, 4, 7, 2};
        int[] arr = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        int numberOfLIS1 = solution673.findNumberOfLIS1(arr);
        System.out.println();
        System.out.println(numberOfLIS1);

       /* int numberOfLIS = solution673.findNumberOfLIS(arr);
        System.out.println(numberOfLIS);*/
    }

    public int findNumberOfLIS(int[] nums) {

        int length = nums.length;
        int[][] dp = new int[length][length + 1];
        //以当字符结尾，且长度为1的话只能有一种情况，就是保留当前字符，其他的均舍弃
        for (int i = 0; i < length; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            int num = nums[i];
            for (int k = 0; k < i; k++) {
                if (nums[k] < num) {
                    for (int j = 0; j < length; j++) {
                        if (dp[k][j] > 0) {
                            dp[i][j + 1] = dp[i][j + 1] + dp[k][j];
                        }
                    }
                }
            }
        }
        print(dp);
        int sum = 0;
        for (int i = length; i >= 0; i--) {
            for (int j = 0; j < length; j++) {
                sum += dp[j][i];
            }
            if (sum > 0) {
                break;
            }
        }
        return sum;
    }

    public int findNumberOfLIS1(int[] nums) {
        int len = nums.length;
        // 动态规划数组，下标代表以当前字符结尾，val代表以当前字符结尾的最大长度
        int[] dp = new int[len];
        // 计数数组，下标代表以当前字符结尾，val代表以当前字符结尾的最大长度的个数
        int[] count = new int[len];

        int max = 0;
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            // 以当前字符结尾且长度为1，只有一种可能，就是只有当前字符本身
            dp[i] = 1;
            count[i] = 1;
            int val = nums[i];
            for (int j = 0; j < i; j++) {
                if (val > nums[j]) {
                    // 长度
                    int c = dp[j] + 1;
                    if (dp[i] == c) {
                        count[i] = count[i] + count[j];
                    } else if (c > dp[i]) {
                        count[i] = count[j];
                        dp[i] = c;
                    }
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                res = count[i];
            } else if (dp[i] == max) {
                res += count[i];
            }
        }
        print1(nums, dp, count);
        return res;
    }

    private void print1(int[] nums, int[] dp, int[] count) {
        System.out.print("nums  ");
        Arrays.stream(nums).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        System.out.print("dp    ");
        Arrays.stream(dp).forEach(x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        System.out.print("count ");
        Arrays.stream(count).forEach(x -> {
            System.out.print(x + " ");
        });
    }

    private void print(int[][] dp) {
        System.out.println("begin");
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("end");
    }
}