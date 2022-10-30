package com.trip.algorithm.leet.some.leet2209;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2022年09月22日 21:43:00
 * Solution1640
 * 1640. 能否连接形成数组
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * <p>
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [15,88], pieces = [[88],[15]]
 * 输出：true
 * 解释：依次连接 [15] 和 [88]
 * 示例 2：
 * <p>
 * 输入：arr = [49,18,16], pieces = [[16,18,49]]
 * 输出：false
 * 解释：即便数字相符，也不能重新排列 pieces[0]
 * 示例 3：
 * <p>
 * 输入：arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * 输出：true
 * 解释：依次连接 [91]、[4,64] 和 [78]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * arr 中的整数 互不相同
 * pieces 中的整数 互不相同（也就是说，如果将 pieces 扁平化成一维数组，数组中的所有整数互不相同）
 * 通过次数37,366提交次数61,105
 */
public class Solution1640 {
    public static void main(String[] args) {
        int[] arr = {15, 88};
        int[][] pieces = {{88}, {15}};

      /*  int[] arr = {49, 18, 16};
        int[][] pieces = {{16, 18, 49}};  */

     /*   int[] arr = {49};
        int[][] pieces = {{49}};*/

       /* int[] arr = {91,4,64,78};
        int[][] pieces =  {{78},{4,64},{91}};*/

        Solution1640 solution1640 = new Solution1640();
        boolean b = solution1640.canFormArray(arr, pieces);
        System.out.println(b);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int length = arr.length;
        int length1 = 0;
        for (int[] arr1 : pieces) {
            length1 += arr1.length;
        }
        if (length != length1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            j = 0;
            for (; j < pieces.length; j++) {
                if (!set.contains(j) && val == pieces[j][0]) {
                    set.add(j);
                    break;
                }
            }
            if (j >= pieces.length) {
                return false;
            }
            for (int k = 0; k < pieces[j].length; k++) {
                int t = pieces[j][k];
                if (t != val) {
                    return false;
                }
                i++;
                if (i >= arr.length) {
                    break;
                }
                val = arr[i];
            }
            i--;
        }
        return true;
    }


}
