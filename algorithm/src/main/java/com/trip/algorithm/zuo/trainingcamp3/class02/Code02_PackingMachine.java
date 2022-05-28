package com.trip.algorithm.zuo.trainingcamp3.class02;

import java.util.Arrays;

/**
 * 有n个打包机器从左到右一字排开，上方有一个自动装置会抓取一批放物品到每个打 包机上，
 * 放到每个机器上的这些物品数量有多有少，由于物品数量不相同，需要工人 将每个机器上的物品进行移动从而到达物品数量相等才能打包。
 * 每个物品重量太大、 每次只能搬一个物品进行移动，为了省力，只在相邻的机器上移动。请计算在搬动最 小轮数的前提下，
 * 使每个机器上的物品数量相等。如果不能使每个机器上的物品相同， 返回-1。
 * <p>
 * 例如[1,0,5]表示有3个机器，每个机器上分别有1、0、5个物品，经过这些轮后:
 * 第一轮:1    0 <- 5 => 1 1 4 第二轮:1 <- 1 <- 4 => 2 1 3 第三轮:2    1 <- 3 => 2 2 2
 * 移动了3轮，每个机器上的物品相等，所以返回3
 * 例如[2,2,3]表示有3个机器，每个机器上分别有2、2、3个物品， 这些物品不管怎么移动，都不能使三个机器上物品数量相等，返回-1
 */
public class Code02_PackingMachine {
    /**
     * 贪心算法，枚举每个位置
     * 假设位置为  x ,i为左边多的或者少的衣服；j为右边多的或者少的衣服
     * i>0 x j>0 -->  Math.max(i,j);
     * i>0 x j<0 -->  Math.max(i,j);
     * i<0 x j>0 -->  Math.max(i,j);
     * i<0 x j<0 -->  i+j-->因为这个位置每次只能往左扔衣服，或者往右扔衣服;
     *
     * @param arr
     * @return
     */
    public static int MinOps(int[] arr) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        int k = sum / n;
        // 除不尽即没办法平均分配衣服
        if (sum % n != 0) {
            return -1;
        }
        int leftTotal = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 左边 为负 说明少，
            int leftRest = leftTotal - i * k;
            // 右边剩余 为负 说明少
            int rightRest = (sum - leftTotal - arr[i]) - (n - i - 1) * k;

            if (leftRest < 0 && rightRest < 0) {
                ans = Math.max(ans, Math.abs(leftRest) + Math.abs(rightRest));
            } else {
                ans = Math.max(ans, Math.max(Math.abs(leftRest), Math.abs(rightRest)));
            }
            leftTotal = leftTotal + arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,0,5};
        int i = MinOps(arr);
        System.out.println(i);
    }
}
