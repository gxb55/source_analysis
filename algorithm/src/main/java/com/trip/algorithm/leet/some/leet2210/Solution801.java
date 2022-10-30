package com.trip.algorithm.leet.some.leet2210;

/**
 * @author xbguo
 * @createTime 2022年10月10日 22:09:00
 * 801. 使序列递增的最小交换次数
 * 我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。
 * <p>
 * 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3,4] 和 nums2 =[5,6,7,8] 。
 * 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。
 * <p>
 * 数组 arr 严格递增 且  arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。
 * <p>
 * 注意：
 * <p>
 * 用例保证可以实现操作。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
 * 输出: 1
 * 解释:
 * 交换 A[3] 和 B[3] 后，两个数组如下:
 * A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
 * 两个数组均为严格递增的。
 * 示例 2:
 * <p>
 * 输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
 * 输出: 1
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= nums1.length <= 105
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 2 * 105
 */
public class Solution801 {
    public static void main(String[] args) {
        Solution801 solution801 = new Solution801();
       // int[] nums1 = {1, 3, 5, 4}, nums2 = {1, 2, 3, 7};
       // int[] nums1 = {0,3,5,8,9}, nums2 = {2,1,4,6,9};
        int[] nums1 = {1,3,5,4}, nums2 = {1,2,3,7};

        int i = solution801.minSwap(nums1, nums2);
        System.out.println(i);
    }

    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[2][len];
        dp[0][0]=0;
        dp[1][0]=1;
        for (int i = 1; i < nums1.length; i++) {
            int a2 = nums1[i];
            int a1 = nums1[i - 1];
            int b2 = nums2[i];
            int b1 = nums2[i - 1];
            if (a2 > a1 && b2 > b1 && a2 > b1 && b2 > a1) {
                dp[0][i] = Math.min(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = dp[0][i]+1;
            } else if (a2 > a1 && b2 > b1) {
                // 各自大于各自的，不能交换
                // 当前不交换，上一个也不交换
                dp[0][i] = dp[0][i - 1];
                // 如果当前要交换，则上一个也要交换才行
                dp[1][i] = dp[1][i - 1] + 1;
            } else {
                // 必须要交换才行
                // 当前不交换，上一个要交换
                dp[0][i] = dp[1][i - 1];
                // 当前交换，上一个不交换
                dp[1][i] = dp[0][i - 1] + 1;
            }
        }
        return Math.min(dp[0][len - 1], dp[1][len - 1]);
    }
}
