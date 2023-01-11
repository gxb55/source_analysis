package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2022/4/14  9:46
 * @description 1672
 * 1672. 最富有客户的资产总量
 * 给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i​​​​​​​​​​​​ 位客户在第 j 家银行托管的资产数量。返回最富有客户所拥有的 资产总量 。
 * <p>
 * 客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：accounts = [[1,2,3],[3,2,1]]
 * 输出：6
 * 解释：
 * 第 1 位客户的资产总量 = 1 + 2 + 3 = 6
 * 第 2 位客户的资产总量 = 3 + 2 + 1 = 6
 * 两位客户都是最富有的，资产总量都是 6 ，所以返回 6 。
 * 示例 2：
 * <p>
 * 输入：accounts = [[1,5],[7,3],[3,5]]
 * 输出：10
 * 解释：
 * 第 1 位客户的资产总量 = 6
 * 第 2 位客户的资产总量 = 10
 * 第 3 位客户的资产总量 = 8
 * 第 2 位客户是最富有的，资产总量是 10
 * 示例 3：
 * <p>
 * 输入：accounts = [[2,8,7],[7,1,3],[1,9,5]]
 * 输出：17
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == accounts.length
 * n == accounts[i].length
 * 1 <= m, n <= 50
 * 1 <= accounts[i][j] <= 100
 * 通过次数56,595提交次数65,485
 */
public class Solution1672 {
    public static void main(String[] args) {
        Solution1672 solution1672 = new Solution1672();
        int[][] accounts = {{2,8,7},{7,1,3},{1,9,5}};
        int i = solution1672.maximumWealth(accounts);
        System.out.println(i);
    }

    public int maximumWealth(int[][] accounts) {
        int max = -1;
        int len = accounts.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int i1 : accounts[i]) {
                sum += i1;
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}
