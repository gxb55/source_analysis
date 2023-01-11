package com.trip.algorithm.codethink.recall;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/1/11 10:27
 * @description 216
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 2 <= k <= 9
 * 1 <= n <= 60
 * 通过次数223,266提交次数309,557
 */
public class Solution216 {
    public static void main(String[] args) {
        Solution216 solution216 = new Solution216();
        int k = 3, n = 7;
        List<List<Integer>> list = solution216.combinationSum4(k,n);
        list.forEach(x->{
            System.out.println(x);
        });
    }

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        process(k, n, 0, 1, tempList, list);
        return list;
    }

    private void process(int count, int sum, int curSum, int index, List<Integer> tempList, List<List<Integer>> list) {
        if(curSum>sum){
            return;
        }
        if (tempList.size() == count && sum == curSum) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = index; i <= 9; i++) {
            tempList.add(i);
            process(count, sum, curSum + i, i+1, tempList, list);
            tempList.remove(Integer.valueOf(i));
        }
    }


    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum4(int k, int n) {
        for (int mask = 0; mask < (1 << 9); ++mask) {
            if (check(mask, k, n)) {
                ans.add(new ArrayList<Integer>(temp));
            }
        }
        return ans;
    }

    public boolean check(int mask, int k, int n) {
        temp.clear();
        for (int i = 0; i < 9; ++i) {
            if (((1 << i) & mask) != 0) {
                temp.add(i + 1);
            }
        }
        if (temp.size() != k) {
            return false;
        }
        int sum = 0;
        for (int num : temp) {
            sum += num;
        }
        return sum == n;
    }

}
