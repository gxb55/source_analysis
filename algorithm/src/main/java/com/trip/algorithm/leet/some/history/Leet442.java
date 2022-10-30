package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年05月08日 16:00:00
 * 442. 数组中重复的数据
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 *
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * 示例 2：
 *
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 * 通过次数73,457提交次数100,006
 */
public class Leet442 {
    public static void main(String[] args) {

    }
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list =new ArrayList<>();
        for (Integer n:nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
                list.add(n);
            }else{
                map.put(n,1);
            }
        }
        return list;
    }
}
