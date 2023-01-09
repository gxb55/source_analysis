package com.trip.algorithm.leet.some.leet11;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/11/15 11:13
 * @description Solution1710
 * 1710. 卡车上的最大单元数
 * 请你将一些箱子装在 一辆卡车 上。给你一个二维数组 boxTypes ，其中 boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi] ：
 * <p>
 * numberOfBoxesi 是类型 i 的箱子的数量。
 * numberOfUnitsPerBoxi 是类型 i 每个箱子可以装载的单元数量。
 * 整数 truckSize 表示卡车上可以装载 箱子 的 最大数量 。
 * 只要箱子数量不超过 truckSize ，你就可以选择任意箱子装到卡车上。
 * <p>
 * 返回卡车可以装载 单元 的 最大 总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * 输出：8
 * 解释：箱子的情况如下：
 * - 1 个第一类的箱子，里面含 3 个单元。
 * - 2 个第二类的箱子，每个里面含 2 个单元。
 * - 3 个第三类的箱子，每个里面含 1 个单元。
 * 可以选择第一类和第二类的所有箱子，以及第三类的一个箱子。
 * 单元总数 = (1 * 3) + (2 * 2) + (1 * 1) = 8
 * 示例 2：
 * <p>
 * 输入：boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * 输出：91
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 * 通过次数30,026提交次数40,974
 */
public class Solution1710 {
    public static void main(String[] args) {
        Solution1710 solution1710 = new Solution1710();
        /*int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;*/
        int[][] boxTypes = {{5,10},{2,5},{4,7},{3,9}};
        int truckSize =   10;
        int i = solution1710.maximumUnits(boxTypes, truckSize);
        System.out.println(i);
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        List<int[]> collect = Arrays.stream(boxTypes).sorted((x, y) -> y[1] - x[1]).collect(Collectors.toList());
        int sum = 0;
        for (int[] arr : collect) {
            if (truckSize > arr[0]) {
                sum = sum + arr[0] * arr[1];
                truckSize -= arr[0];
            } else {
                sum = sum + truckSize * arr[1];
                break;
            }
        }
        return sum;
    }
}
