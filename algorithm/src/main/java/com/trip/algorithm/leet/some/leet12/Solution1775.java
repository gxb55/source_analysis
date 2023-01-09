package com.trip.algorithm.leet.some.leet12;

/**
 * @author xbguo
 * @date 2022/12/7 09:43
 * @description 1775
 */
public class Solution1775 {
    public static void main(String[] args) {
       /* int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 1, 2, 2, 2, 2};*/

      /*  int[] nums1 = {6, 6};
        int[] nums2 = {1};*/

       /* int[] nums1 = {5,6,4,3,1,2};
        int[] nums2 = {6,3,3,1,4,5,3,4,1,3,4}; */

        int[] nums1 = {5,2,1,5,2,2,2,2,4,3,3,5};
        int[] nums2 = {1,4,5,5,6,3,1,3,3};

        Solution1775 solution1775 = new Solution1775();
        int i = solution1775.minOperations(nums1, nums2);
        System.out.println(i);
        System.out.println("=========================");
        System.out.println(solution1775.minOperations1(nums1, nums2));
    }

    public int minOperations1(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length) {
            return -1;
        }
        int sum = 0;
        for (int x : nums1) {
            sum += x;
        }
        for (int x : nums2) {
            sum -= x;
        }
        if (sum < 0) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        sum= Math.abs(sum);
        // nums1 变小；nums2变大；
        int[] dp = new int[7];
        for (int x : nums1) {
            dp[x - 1]++;
        }
        for (int x : nums2) {
            dp[6 - x]++;
        }
        int res = 0;
        for (int i = 5; i >= 1; i--) {
            int count = dp[i];
            if ((count * i) > sum) {
                res = res + ((sum / i) + (sum%i==0?0:1));
                break;
            }
            sum = sum - (count * i);
            res = res + count;
        }
        return res;
    }


    public int minOperations(int[] nums1, int[] nums2) {
        if (6 * nums1.length < nums2.length || 6 * nums2.length < nums1.length)
            return -1; // 优化
        // int d = Arrays.stream(nums2).sum() - Arrays.stream(nums1).sum();
        int d = 0; // 数组元素和的差，我们要让这个差变为 0
        for (int x : nums2) d += x;
        for (int x : nums1) d -= x;
        if (d < 0) {
            d = -d;
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp; // 交换，统一让 nums1 的数变大，nums2 的数变小
        }
        int[] cnt = new int[6]; // 统计每个数的最大变化量
        for (int x : nums1) {
            ++cnt[6 - x]; // nums1 的变成 6
        }
        for (int x : nums2) {
            ++cnt[x - 1]; // nums2 的变成 1
        }
        for (int i = 5, ans = 0; ; --i) { // 从大到小枚举最大变化量 5 4 3 2 1
            if (i * cnt[i] >= d) // 可以让 d 变为 0
                return ans + (d + i - 1) / i;
            ans += cnt[i]; // 需要所有最大变化量为 i 的数
            d -= i * cnt[i];
        }
    }


}
