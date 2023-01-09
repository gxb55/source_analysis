package com.trip.algorithm.leet.some.history;

import org.openjdk.jol.info.ClassLayout;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2022/6/17  13:51
 * @description 1089. 复写零
 * 1089. 复写零
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * <p>
 * 注意：请不要在超过该数组长度的位置写入元素。
 * <p>
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 * <p>
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 * 通过次数36,751提交次数60,684
 */
public class Solution1089 {
    public static void main(String[] args) {
        Solution1089 solution1089 = new Solution1089();
        //  int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        //  int[] arr = {1, 2, 3, 4, 5};
        int[] arr = {0, 0, 0, 0, 0, 0, 0};
        solution1089.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("-------------------------");
        System.out.println(ClassLayout.parseInstance(arr).toPrintable());
    }

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = arr[i];
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (index >= len) {
                break;
            }
            int re = res[i];
            if (re == 0) {
                arr[index++] = re;
                if (index >= len) {
                    break;
                }
                arr[index++] = re;
            } else {
                arr[index++] = re;
            }
        }

    }
}
