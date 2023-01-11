package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/3/14  17:16
 * @description TODO
 * 599. 两个列表的最小索引总和
 * 假设 Andy 和 Doris 想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。
 * <p>
 * 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设答案总是存在。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 * 输出: ["Shogun"]
 * 解释: 他们唯一共同喜爱的餐厅是“Shogun”。
 * 示例 2:
 * <p>
 * 输入:list1 = ["Shogun", "Tapioca Express", "Burger King", "KFC"]，list2 = ["KFC", "Shogun", "Burger King"]
 * 输出: ["Shogun"]
 * 解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= list1.length, list2.length <= 1000
 * 1 <= list1[i].length, list2[i].length <= 30
 * list1[i] 和 list2[i] 由空格 ' ' 和英文字母组成。
 * list1 的所有字符串都是 唯一 的。
 * list2 中的所有字符串都是 唯一 的。
 * 通过次数58,227提交次数102,905
 */
public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> list = new ArrayList<>();
        int cur = -1;
        List<String> stringList1 = Arrays.asList(list1);
        List<String> stringList2 = Arrays.asList(list2);
        for (String str : stringList1) {
            if (stringList2.contains(str)) {
                int i = stringList1.indexOf(str);
                int j = stringList2.indexOf(str);
                if (cur == -1) {
                    cur = i + j;
                    list.add(str);
                } else if (cur > (i + j)) {
                    list.clear();
                    cur = i + j;
                    list.add(str);
                }else if (cur == (i + j)){
                    list.add(str);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        Solution599 solution599 = new Solution599();

        String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] arr2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = solution599.findRestaurant(arr1, arr2);
        Arrays.stream(restaurant).forEach(x -> {
            System.out.println(x);
        });
    }
}
