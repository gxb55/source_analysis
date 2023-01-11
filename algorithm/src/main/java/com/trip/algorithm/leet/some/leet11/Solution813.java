package com.trip.algorithm.leet.some.leet11;

import java.util.*;

/**
 * @author xbguo
 * @date 2022/11/28 15:32
 * @description Solution813
 * 813. 最大平均值和的分组
 * 给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个相邻的非空子数组 。 分数 由每个子数组内的平均值的总和构成。
 * <p>
 * 注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
 * <p>
 * 返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [9,1,2,3,9], k = 3
 * 输出: 20.00000
 * 解释:
 * nums 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
 * 我们也可以把 nums 分成[9, 1], [2], [3, 9].
 * 这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 4
 * 输出: 20.50000
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * 通过次数18,265提交次数30,536
 */
public class Solution813 {
    public static void main(String[] args) {
        Solution813 solution813 = new Solution813();
      /*  int[] nums = {9, 1, 2, 3, 9};
        int k = 3;  */
       /* int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;  */

        int[] nums = {4, 1, 7, 5, 6, 2, 3};
        int k = 4;


        double v = solution813.largestSumOfAverages(nums, k);
        System.out.println(v);
    }

    public double largestSumOfAverages(int[] nums, int k) {
        int length = nums.length;
        double[] sum = new double[length+1];
        double res=0;
        for (int i = 1; i <length+1; i++) {
            res= res+nums[i-1];
            sum[i]=res;
        }
        double[][] dp = new double[length+1][k+1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= Math.min(i,k); j++) {
                if(j==1){
                    dp[i][j]=sum[j]/i;
                }else{
                    for (int l = 2; l <= i; l++) {
                        dp[i][j]=Math.max(dp[i][j],dp[l-1][j-1]+(sum[i]-sum[l-1]/(i-l+1)));
                    }
                }
            }
        }
        return dp[length][k];
    }

    public double largestSumOfAverages1(int[] nums, int k) {
        int length = nums.length;
        if (k == 1) {
            return Arrays.stream(nums).sum() / (double) nums.length;
        }
        int t = k;
        List<LinkedList<Integer>> list = new ArrayList<>();
        List<Integer> sumList = new ArrayList<>();
        List<Double> resList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int val = nums[i];
            LinkedList<Integer> integerList = new LinkedList<>();
            if (t == 1) {
                while (i < length) {
                    val = nums[i];
                    integerList.add(val);
                    i++;
                }
                list.add(integerList);
            } else {
                integerList.add(val);
                list.add(integerList);
                t--;
            }
        }
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Integer> list1 = list.get(i);
            int sum = list1.stream().mapToInt(x -> x).sum();
            sumList.add(sum);
            resList.add((sum / (double) (list1.size())));
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            LinkedList<Integer> list1 = list.get(i);
            if (i - 1 < 0) {
                break;
            }
            LinkedList<Integer> list2 = list.get(i - 1);
            int sum1 = sumList.get(i);
            int sum2 = sumList.get(i - 1);
            double cur = resList.get(i) + resList.get(i - 1);
            double next = 0;
            while (next > cur || next == 0) {
                if (next == 0) {
                    Integer remove = list1.pollFirst();
                    list2.addLast(remove);
                    sum1 = sum1 - remove;
                    sum2 = sum2 + remove;
                    next = sum1 / list1.size() + sum2 / list2.size();
                } else {
                    Integer remove = list1.remove(0);
                    list2.add(remove);
                    sum1 = sum1 - remove;
                    sum2 = sum2 + remove;
                    cur = next;
                    next = sum1 / list1.size() + sum2 / list2.size();
                }
            }

            Integer integer = list2.pollLast();
            list1.addFirst(integer);

            resList.set(i, (sum1 / (double) list1.size()));
            resList.set(i - 1, (sum2 / (double) list2.size()));
            result = result + sum1 / list1.size();
        }
        return result;
    }
}
