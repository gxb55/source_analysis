package com.trip.algorithm.leet.some;

/**
 * @author Administrator
 * 135. 分发糖果
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 示例 2：
 * <p>
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == ratings.length
 * 1 <= n <= 2 * 104
 * 0 <= ratings[i] <= 2 * 104
 * 通过次数125,970提交次数258,179
 * graph
 */
public class Leet_135 {
    public static void main(String[] args) {
        Leet_135 leet_135 = new Leet_135();
        int[] arr = {1, 3, 4, 5, 2};
        int candy = leet_135.candy(arr);
        System.out.println(candy);
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }
        //从左到右
        for (int i = 0; i < n - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                if (arr[i + 1] <= arr[i]) {
                    arr[i + 1] = arr[i] + 1;
                }
            }
        }

        for (int i = n - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                if (arr[i - 1] <= arr[i]) {
                    arr[i - 1] = arr[i] + 1;
                }
            }
        }
        int result = 0;
        for (int i : arr) {
            result += i;
        }
        return result;
    }
}
