package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @createTime 2022年04月10日 19:48:00
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * 通过次数242,248提交次数605,348
 */
public class Leet_63 {
    public static void main(String[] args) {
        Leet_63 leet_63 = new Leet_63();
        int[][] obstacleGrid =  {
                {0,0,0},
                {0,1,0},
                {0,0,0}};
        int i = leet_63.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(i);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        if (obstacleGrid[x - 1][y - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        if(x==1&&y==1){
            return 1;
        }
        int dp[][] = new int[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = obstacleGrid[i][j];
                }
            }
        }
        dp[0][0]=1;
        for (int i = 1; i < x; i++) {
            if (dp[i][0] != -1 && dp[i-1][0]!=-1) {
                dp[i][0] = dp[i-1][0];
            }
        }
        for (int i = 1; i < y; i++) {
            if (dp[0][i] != -1 && dp[0][i-1] != -1) {
                dp[0][i] = dp[0][i-1];
            }
        }

        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                int l = dp[i][j - 1] == -1 ? 0 : dp[i][j - 1];
                int r = dp[i - 1][j] == -1 ? 0 : dp[i - 1][j];
                if (dp[i][j] == 0) {
                    dp[i][j] = l + r;
                }
            }
        }
        return dp[x - 1][y - 1];
    }
}
