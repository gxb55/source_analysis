package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2021/12/30  16:25
 * @description 剑指 Offer II 075. 数组相对排序
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/0H97ZC
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * [28,6,22,8,44,17]
 * [22,28,8,6]
 *
 * [2,3,1,3,2,4,6,7,9,2,19]
 * [2,1,4,3,9,6]
 */
public class SolutionOfferTwo0753 {
    public static void main(String[] args) {
        SolutionOfferTwo0753 solutionOfferTwo0753 = new SolutionOfferTwo0753();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19}, arr2 = {2,1,4,3,9,6};
        int[] ints = solutionOfferTwo0753.relativeSortArray(arr1, arr2);
        for (int i : ints) {
            System.out.println(i);
        }
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        List<Integer> otherList = new ArrayList<>();
        for (int x : arr1) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
            otherList.add(x);
        }
        for (Integer x : arr2) {
            if (map.containsKey(x)) {
                int size = map.get(x);
                for (int i = 0; i < size; i++) {
                    result.add(x);
                    otherList.remove(x);
                }
            }

        }

        otherList.sort(Integer::compareTo);
        result.addAll(otherList);
        int[] arr = new int[arr1.length];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;

    }

}
