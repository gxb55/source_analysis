package com.trip.algorithm.leet.some.leet2305;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/5/15 15:06
 * 输入：matrix = {{0,1},{1,1}}
 * 输出：1
 * 解释：不进行翻转，有 1 行所有值都相等。
 * 示例 2：
 * <p>
 * 输入：matrix = {{0,1},{1,0}}
 * 输出：2
 * 解释：翻转第一列的值之后，这两行都由相等的值组成。
 * 示例 3：
 * <p>
 * 输入：matrix = {{0,0,0},{0,0,1},{1,1,0}}
 * 输出：2
 * 解释：翻转前两列的值之后，后两行由相等的值组成。
 */
public class Solution1072 {
    public static void main(String[] args) {
       // int[][] matrix = {{0, 1}, {1, 1}};
      // int[][] matrix = {{0,1},{1,0}};
        int[][] matrix = {{0,0,0},{0,0,1},{1,1,0}};
        int i = maxEqualRowsAfterFlips(matrix);
        System.out.println(i);
    }

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder stringBuilder1 = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            stringBuilder1.setLength(0);
            stringBuilder2.setLength(0);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    stringBuilder1.append(j).append("_");
                } else {
                    stringBuilder2.append(j).append("_");
                }
            }
            String str1 = stringBuilder1.toString();
            String str2 = stringBuilder2.toString();
            map.put(str1, map.getOrDefault(str1, 0) + 1);
            map.put(str2, map.getOrDefault(str2, 0) + 1);
            max = Math.max(max, map.get(str1));
            max = Math.max(max, map.get(str2));
        }
        return max;
    }
}
