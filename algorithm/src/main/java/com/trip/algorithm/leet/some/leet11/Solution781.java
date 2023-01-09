package com.trip.algorithm.leet.some.leet11;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/11/17 16:47
 * <p>
 * 781. 森林中的兔子
 * 森林中有未知数量的兔子。提问其中若干只兔子 "还有多少只兔子与你（指被提问的兔子）颜色相同?" ，将答案收集到一个整数数组 answers 中，其中 answers[i] 是第 i 只兔子的回答。
 * <p>
 * 给你数组 answers ，返回森林中兔子的最少数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：answers = [1,1,2]
 * 输出：5
 * 解释：
 * 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
 * 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
 * 设回答了 "2" 的兔子为蓝色。
 * 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
 * 因此森林中兔子的最少数量是 5 只：3 只回答的和 2 只没有回答的。
 * 示例 2：
 * <p>
 * 输入：answers = [10,10,10]
 * 输出：11
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= answers.length <= 1000
 * 0 <= answers[i] < 1000
 * 通过次数52,762提交次数88,904
 */
public class Solution781 {
    public static void main(String[] args) {
        Solution781 solution781 = new Solution781();
       // int[] answers = {1,1,2};
        int[] answers = {10,10,10};
      //  int[] answers = {10,10,10,10,10,10,10,10,10,10,10,10};
        //int[] answers = {1,2,1};
        int i = solution781.numRabbits(answers);
        System.out.println(i);
    }

    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : answers) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 3个兔子
            Integer key = entry.getKey();
            // 有9个人跟我一样
            // 有1个人跟我一样
            Integer value = entry.getValue();
            if(value==1){
                count = count+key + 1;
            } else if (value <= key) {
                count = count+key + 1;
            } else {
                int i = value / (key + 1);
                count = count + (key + 1)*i;
                if (value % (key + 1) != 0) {
                    count = count + key + 1;
                }
            }
        }
        return count;
    }


}
