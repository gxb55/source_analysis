package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2022/3/30  21:43
 * <p>
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * 通过次数272,189提交次数395,348
 */
public class Solution739 {
    public static void main(String[] args) {
        int temperatures[] = {30,60,90};
        Solution739 solution739 = new Solution739();
        int[] ints = solution739.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        List<Temp> list = new ArrayList<>();

        for (int i = 0; i < temperatures.length; i++) {
            int val = temperatures[i];
            Temp temp = new Temp(i, val);
            while (!list.isEmpty() && list.get(list.size() - 1).value < val) {
                Temp temp1 = list.get(list.size() - 1);
                result[temp1.index] = i - temp1.index;
                list.remove(list.size()-1);
            }
            list.add(temp);
        }
        return result;
    }
}

class Temp {
    int index;
    int value;

    public Temp() {
    }

    public Temp(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
