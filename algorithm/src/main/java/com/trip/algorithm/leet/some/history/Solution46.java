package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/2/16  15:27
 * @description 全排列
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * 通过次数509,566提交次数649,282
 *
 * 回溯
 *  例如 1 2 3
 *  第一次 1
 *  再调用 1 2
 *  在调用 1 2 3 ，调用结束 3出去，返回上一层，上一层入得是2 2出去，循环到3了，3进去就是 1 3
 *
 */
public class Solution46 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Solution46 solution = new Solution46();
        List<List<Integer>> permute = solution.permute(arr);
        permute.stream().forEach(x->{
            System.out.println(x);
        });
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        getResultList(nums, list, list1);
        return list;
    }

    private void getResultList(int[] nums, List<List<Integer>> list, List<Integer> list1) {
        if (nums.length==list1.size()) {
            list.add(new ArrayList<>(list1));
            return;
        }
        for (Integer integer:nums){
            if(!list1.contains(integer)){
                list1.add(integer);
                getResultList(nums,list,list1);
                list1.remove(list1.size()-1);
            }
        }
    }
}
