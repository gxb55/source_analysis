package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xbguo
 * @date 2022/3/30  22:07
 * <p>
 * 853. 车队
 * 在一条单行道上，有 n 辆车开往同一目的地。目的地是几英里以外的 target 。
 * <p>
 * 给定两个整数数组 position 和 speed ，长度都是 n ，其中 position[i] 是第 i 辆车的位置， speed[i] 是第 i 辆车的速度(单位是英里/小时)。
 * <p>
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车 以相同的速度 紧接着行驶。此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * <p>
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * <p>
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * <p>
 * 返回到达目的地的 车队数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * 输出：3
 * 解释：
 * 从 10 和 8 开始的车会组成一个车队，它们在 12 处相遇。
 * 从 0 处开始的车无法追上其它车，所以它自己就是一个车队。
 * 从 5 和 3 开始的车会组成一个车队，它们在 6 处相遇。
 * 请注意，在到达目的地之前没有其它车会遇到这些车队，所以答案是 3。
 * 示例 2:
 * <p>
 * 输入: target = 10, position = [3], speed = [3]
 * 输出: 1
 * 解释: 只有一辆车，因此只有一个车队。
 * 示例 3:
 * <p>
 * 输入: target = 100, position = [0,2,4], speed = [4,2,1]
 * 输出: 1
 * 解释:
 * 以0(速度4)和2(速度2)出发的车辆组成车队，在4点相遇。舰队以2的速度前进。
 * 然后，车队(速度2)和以4(速度1)出发的汽车组成一个车队，在6点相遇。舰队以1的速度前进，直到到达目标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == position.length == speed.length
 * 1 <= n <= 105
 * 0 < target <= 106
 * 0 <= position[i] < target
 * position 中每个值都 不同
 * 0 < speed[i] <= 106
 */
public class Solution853 {
    public static void main(String[] args) {
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        Solution853 solution853 = new Solution853();
        int i = solution853.carFleet(target, position, speed);
        System.out.println(i);

    }

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }
        Map<Integer, Temp> map = new HashMap();
        boolean first = true;
        int index = 0;
        while (true) {
            for (int i = 0; i < position.length; i++) {
                int cur = position[i] + index * speed[i];
                Temp temp = map.get(cur);
                int lastSpeed;
                if (temp == null) {
                    temp = new Temp();
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(i);
                    lastSpeed = speed[i];
                    temp.list = list1;
                    temp.curSpeed = speed[i];
                } else {
                    lastSpeed = speed[i];
                    temp.list.add(i);
                    int max = 0;
                    for (int i1 : temp.list) {
                        max = Math.max(max, i1);
                    }
                    temp.curSpeed = speed[max];
                }

                if (!first) {
                    int last = cur - lastSpeed;
                    map.get(last).list.remove(i);
                    if (map.get(last).list.size() == 0) {
                        map.remove(last);
                    }
                }
                map.put(cur, temp);
            }
            Optional<Integer> any = map.keySet().stream().filter(x -> x > target).findAny();
            if (any.isPresent()) {
                return map.size();
            }
            first = false;
            index++;
            if (map.size() == 1) {
                return 1;
            }

        }

    }

    class Temp {
        List<Integer> list;
        int curSpeed;

        public Temp() {
        }

        public Temp(List<Integer> list, int curSpeed) {
            this.list = list;
            this.curSpeed = curSpeed;
        }
    }
}

