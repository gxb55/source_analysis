package com.trip.algorithm.leet.some.history;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/3/25  11:13
 * @description 974
 * 974. 和可被 K 整除的子数组
 * 给定一个整数数组 nums 和一个整数 k ，返回其中元素之和可被 k 整除的（连续、非空） 子数组 的数目。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,5,0,-2,-3,1], k = 5
 * 输出：7
 * 解释：
 * 有 7 个子数组满足其元素之和可被 k = 5 整除：
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 * 示例 2:
 * <p>
 * 输入: nums = [5], k = 9
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * 2 <= k <= 104
 * 通过次数43,289提交次数92,116
 */
public class Solution974 {
    public static void main(String[] args) {
        Solution974 solution974 = new Solution974();
        /*int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;*/
        int[] arr = {-1,2,9};
        int k = 2;
        int i = solution974.subarraysDivByK(arr, k);
        System.out.println(i);
    }

    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // key 值 value是个数，即这个key有value个
        map.put(0, 1);
        for (int t : nums) {
            sum = sum + t;
            int q = sum % k;
            if (map.containsKey(q)) {
                result = result + map.get(q);
            }
            map.put(q, map.getOrDefault(q, 0) + 1);
        }
        return result;
    }

    public int subarraysDivByK1(int[] A, int K) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int presum = 0;
        int count = 0;
        for (int x : A) {
            presum += x;
            //当前 presum 与 K的关系，余数是几，当被除数为负数时取模结果为负数，需要纠正
            //int key = (presum % K + K) % K;
            int key = presum % K;
            //查询哈希表获取之前key也就是余数的次数
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            //存入哈希表当前key，也就是余数
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return count;
    }


}
