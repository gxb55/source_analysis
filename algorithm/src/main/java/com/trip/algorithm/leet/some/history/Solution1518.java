package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo
 * @date 2021/12/17  15:10
 * @description 1518. 换酒问题
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 最多 能喝到多少瓶酒。
 * <p>
 * 示例 1：
 * 输入：numBottles = 9, numExchange = 3
 * 输出：13
 * 解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
 * <p>
 * 示例 2：
 * 输入：numBottles = 15, numExchange = 4
 * 输出：19
 * 解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
 * 所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
 * <p>
 * 示例 3：
 * 输入：numBottles = 5, numExchange = 5
 * 输出：6
 * 示例 4：
 * <p>
 * 输入：numBottles = 2, numExchange = 3
 * 输出：2
 */
public class Solution1518 {

    public static void main(String[] args) {
        Solution1518 solution1518 = new Solution1518();
        int numBottles = 15;
        int numExchange = 4;
        int i = solution1518.numWaterBottles(numBottles, numExchange);
        System.out.println(i);
    }

    /**
     * @param numBottles  买了多少瓶酒
     * @param numExchange 多少个瓶盖可以换一瓶酒
     * @return
     */
    public int numWaterBottles(int numBottles, int numExchange) {
        int have = numBottles;
        int result = numBottles;
        while (have >= numExchange) {
            // 可以换多少瓶酒
            result += have / numExchange;
            // 换完之后有多少个空瓶子，进行下一轮计算
            have = have / numExchange + have % numExchange;
        }
        return result;
    }
}
