package com.trip.algorithm.leet.some.leet11;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author xbguo
 * @date 2022/11/10 15:33
 * @description Solution864
 * 864. 获取所有钥匙的最短路径
 * 给定一个二维网格 grid ，其中：
 * <p>
 * '.' 代表一个空房间
 * '#' 代表一堵
 * '@' 是起点
 * 小写字母代表钥匙
 * 大写字母代表锁
 * 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们手里有对应的钥匙，否则无法通过锁。
 * <p>
 * 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。
 * <p>
 * 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@.a.#","###.#","b.A.B"]
 * 输出：8
 * 解释：目标是获得所有钥匙，而不是打开所有锁。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = ["@..aA","..B#.","....b"]
 * 输出：6
 * 示例 3:
 * <p>
 * <p>
 * 输入: grid = ["@Aa"]
 * 输出: -1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 30
 * grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F'
 * 钥匙的数目范围是 [1, 6]
 * 每个钥匙都对应一个 不同 的字母
 * 每个钥匙正好打开一个对应的锁
 * 通过次数11,004提交次数19,396
 */
public class Solution864 {
    public static void main(String[] args) {
        Solution864 solution864 = new Solution864();
        // String[] grid = {"@.a.#", "###.#", "b.A.B"};
        //   String[] grid = {"@..aA", "..B#.", "....b"};
        //  String[] grid = {"@Aa"};
        String[] grid = {"@...a", ".###A", "b.BCc"};
        int i = solution864.shortestPathAllKeys(grid);
        System.out.println(i);
    }

    /**
     * 给定一个二维网格 grid ，其中：
     * <p>
     * '.' 代表一个空房间
     * '#' 代表一堵
     * '@' 是起点
     * 小写字母代表钥匙
     * 大写字母代表锁 字符串
     *
     * @param grid
     * @return
     */


    public int shortestPathAllKeys(String[] grid) {
        int length = grid.length;
        int length1 = grid[0].length();
        Character[][] arr = new Character[length][length1];
        boolean[][] dp = new boolean[length][length1];
        int x = -1;
        int y = -1;
        int len = 0;
        for (int i = 0; i < grid.length; i++) {
            String s = grid[i];
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                arr[i][j] = chars[j];
                if (chars[j] == '@') {
                    x = i;
                    y = j;
                } else if (chars[j] >= 'a' && chars[j] <= 'z') {
                    len++;
                }
            }
        }
        List<String> list = new ArrayList<>();
        int step = 0;
        process(arr, x, y, list, len, step, dp);
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    int max = Integer.MAX_VALUE;

    private void process(Character[][] arr, int x, int y, List<String> list, int len, int step, boolean[][] dp) {
        if (len == 0) {
            max = Math.min(step - 1, max);
            return;
        }
        if (x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) {
            return;
        }
        Character character = arr[x][y];
        if (character == '#') {
            return;
        }
        if (dp[x][y]) {
            return;
        }
        if (character >= 'A' && character <= 'Z' && !list.stream().map(z -> z.toUpperCase(Locale.ROOT)).anyMatch(t -> t.equals(String.valueOf(character)))) {
            return;
        }
        if (character >= 'a' && character <= 'z') {
            list.add(String.valueOf(character));
            len--;
        }
        dp[x][y] = true;
        process(arr, x + 1, y, list, len, step + 1, dp);
        process(arr, x, y + 1, list, len, step + 1, dp);
        process(arr, x - 1, y, list, len, step + 1, dp);
        process(arr, x, y - 1, list, len, step + 1, dp);
        dp[x][y] = false;
        list.remove(String.valueOf(character));
    }
}
