package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/5/26  15:55
 * @description 699
 * 699. 掉落的方块
 * 在二维平面上的 x 轴上，放置着一些方块。
 * <p>
 * 给你一个二维整数数组 positions ，其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。
 * <p>
 * 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。一个方块仅仅是擦过另一个方块的左侧边或右侧边不算着陆。一旦着陆，它就会固定在原地，无法移动。
 * <p>
 * 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。
 * <p>
 * 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：positions = [[1,2],[2,3],[6,1]]
 * 输出：[2,5,5]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 2 。
 * 第 2 个方块掉落后，最高的堆叠由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 第 3 个方块掉落后，最高的堆叠仍然由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 因此，返回 [2, 5, 5] 作为答案。
 * 示例 2：
 * <p>
 * 输入：positions = [[100,100],[200,100]]
 * 输出：[100,100]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 100 。
 * 第 2 个方块掉落后，最高的堆叠可以由方块 1 组成也可以由方块 2 组成，堆叠的最高高度为 100 。
 * 因此，返回 [100, 100] 作为答案。
 * 注意，方块 2 擦过方块 1 的右侧边，但不会算作在方块 1 上着陆。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= positions.length <= 1000
 * 1 <= lefti <= 108
 * 1 <= sideLengthi <= 106
 * 通过次数11,779提交次数21,880
 */
public class Solution699 {
    public static void main(String[] args) {
        Solution699 solution699 = new Solution699();
        // int[][] positions = {{1, 2}, {2, 3}, {6, 1}};
        // int[][] positions = {{100,100},{200,100}};
        int[][] positions = {{9, 7}, {1, 9}, {3, 1}};
        List<Integer> list = solution699.fallingSquares3(positions);
        System.out.println(list);
    }

    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] arr : positions) {
            int left = arr[0];
            int len = arr[1];
            int cur = 0;
            for (int i = left; i < left + len; i++) {
                Integer orDefault = map.getOrDefault(i, 0);
                cur = Math.max(orDefault, cur);
                map.put(i, orDefault + len);
            }
            for (int i = left; i < left + len; i++) {
                map.put(i, cur + len);
            }
            max = Math.max(max, cur + len);
            list.add(max);
        }
        return list;
    }


    public List<Integer> fallingSquares3(int[][] positions) {
        int n = positions.length;
        List<Integer> heights = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            int left1 = positions[i][0], right1 = positions[i][0] + positions[i][1] - 1;
            int height = positions[i][1];
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = positions[j][0] + positions[j][1] - 1;
                if (right1 >= left2 && right2 >= left1) {
                    height = Math.max(height, heights.get(j) + positions[i][1]);
                }
            }
            heights.add(height);
        }
       for (int i = 1; i < n; i++) {
            heights.set(i, Math.max(heights.get(i), heights.get(i - 1)));
        }
        return heights;
    }

}
