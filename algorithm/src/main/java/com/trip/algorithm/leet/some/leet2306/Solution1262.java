package com.trip.algorithm.leet.some.leet2306;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/6/19 09:48
 * 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * 通过次数24,223提交次数45,038
 */
public class Solution1262 {
    public static void main(String[] args) {
        Solution1262 solution1262 = new Solution1262();
         int[] arr = {3, 6, 5, 1, 8};
        // int[] arr = {1,2,3,4,4};
        //int[] arr = {5, 2, 2, 2};
       // int[] arr = {366, 809, 6, 792, 822, 181, 210, 588, 344, 618, 341, 410, 121, 864, 191, 749, 637, 169, 123, 472, 358, 908, 235, 914, 322, 946, 738, 754, 908, 272, 267, 326, 587, 267, 803, 281, 586, 707, 94, 627, 724, 469, 568, 57, 103, 984, 787, 552, 14, 545, 866, 494, 263, 157, 479, 823, 835, 100, 495, 773, 729, 921, 348, 871, 91, 386, 183, 979, 716, 806, 639, 290, 612, 322, 289, 910, 484, 300, 195, 546, 499, 213, 8, 623, 490, 473, 603, 721, 793, 418, 551, 331, 598, 670, 960, 483, 154, 317, 834, 352};
        int i = solution1262.maxSumDivThree1(arr);
        System.out.println(i);
    }

    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int v = num % 3;
            if (v == 0) {
                sum += num;
            } else if (v == 1) {
                list1.add(new int[]{v, num, i});
            } else {
                list2.add(new int[]{v, num, i});
            }
        }
        list1.sort((o1, o2) -> o2[1] - o1[1]);
        list2.sort((o1, o2) -> o2[1] - o1[1]);
        sum = getRes(sum, list1, list2, 0, 0);
        return sum;
    }

    private int getRes(int sum, List<int[]> list1, List<int[]> list2, int index1, int index2) {
        while (true) {
            int p1 = 0;
            int p2 = 0;
            int p3 = 0;
            if ((index1 + 2) < list1.size() && index1 < list1.size()) {
                p1 = list1.get(index1)[1] + list1.get(index1 + 1)[1] + list1.get(index1 + 2)[1];
            }
            if ((index2 + 2) < list2.size()) {
                p3 = list2.get(index2 + 1)[1] + list2.get(index2 + 2)[1] + list2.get(index2)[1];
            }
            if (index1 < list1.size() && index2 < list2.size()) {
                p2 = list2.get(index2)[1] + list1.get(index1)[1];
            }
            if (p1 == 0 && p2 == 0 && p3 == 0) {
                break;
            }
            if (p3 > p1 && p3 > p2) {
                index2 = index2 + 3;
                sum = sum + p3;
            } else if (p1 > p2 && p1 > p3) {
                index1 = index1 + 3;
                sum = sum + p1;
            } else if (p2 > p1 && p2 > p3) {
                index1++;
                index2++;
                sum = sum + p2;
            } else if (p1 == p2 && p2 == p3) {
                sum = sum + Math.max(Math.max(getRes(0, list1, list2, index1 + 1, index2 + 1), getRes(0, list1, list2, index1 + 3, index2)), getRes(0, list1, list2, index1, index2 + 3));
            }
        }
        return sum;
    }

    public int maxSumDivThree1(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1); // -1 表示没有计算过
        }
        int dfs = dfs(memo, nums, n - 1, 0);
        for(int[] a:memo){
            System.out.println(Arrays.toString(a));
        }
        return dfs;
    }

    private int dfs(int[][] memo, int[] nums, int i, int j) {
        if (i < 0) {
            return j == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j]; // 之前计算过
        }
        return memo[i][j] = Math.max(dfs(memo, nums, i - 1, j),
                dfs(memo, nums, i - 1, (j + nums[i]) % 3) + nums[i]);
    }




}
