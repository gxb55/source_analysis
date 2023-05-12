package com.trip.algorithm.leet.some.leet2304;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo
 * @createTime 2023年04月11日 07:43:00
 * 北方向 是y轴的正方向。
 * 南方向 是y轴的负方向。
 * 东方向 是x轴的正方向。
 * 西方向 是x轴的负方向。
 * 机器人可以接受下列三条指令之一：
 * <p>
 * "G"：直走 1 个单位
 * "L"：左转 90 度
 * "R"：右转 90 度
 */
public class Solution1041 {

    public static void main(String[] args) {
        String instructions = "GGLLGG";
         instructions = "GLGLGGLGL";
       // instructions = "GL";
      //  instructions = "GG";
        boolean robotBounded = isRobotBounded(instructions);
        System.out.println(robotBounded);
    }

    public static boolean isRobotBounded(String instructions) {
        char[] chars = instructions.toCharArray();
        int[] last = new int[]{0, 0, 1};
        int[] fist=null;
        List<int[]> list = new ArrayList<>();
        list.add(last);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                int val = last[2];
                int[] cur = null;
                if (aChar == 'G') {
                    if (val == 1) {
                        cur = new int[]{last[0], last[1] + 1, last[2]};
                    } else if (val == 2) {
                        cur = new int[]{last[0] - 1, last[1], last[2]};
                    } else if (val == 3) {
                        cur = new int[]{last[0], last[1] - 1, last[2]};
                    } else if (val == 4) {
                        cur = new int[]{last[0] + 1, last[1], last[2]};
                    }
                    list.add(cur);
                } else if (aChar == 'L') {
                    if (val == 4) {
                        cur = new int[]{last[0], last[1], 1};
                    } else {
                        cur = new int[]{last[0], last[1], last[2] + 1};
                    }
                } else if (aChar == 'R') {
                    if (val == 1) {
                        cur = new int[]{last[0], last[1], 4};
                    } else {
                        cur = new int[]{last[0], last[1], last[2] - 1};
                    }
                }
                last = cur;
                if(i==0&&j==0){
                    fist=cur;
                }
                if(i>0&&j==0){
                    if(fist[0]==cur[0]&&fist[1]==cur[1]&&fist[2]==cur[2]){
                        return true;
                    }
                }
            }
        }
      /*  int slowIndex = 0;
        int quickIndex = 0;
        while (quickIndex < list.size()) {
            if (slowIndex != 0
                    && list.get(slowIndex)[0] == list.get(quickIndex)[0]
                    && list.get(slowIndex)[1] == list.get(quickIndex)[1]
                    && list.get(slowIndex)[2] == list.get(quickIndex)[2]
            ) {
                return true;
            }
            slowIndex++;
            quickIndex++;
            quickIndex++;
        }*/
        return false;
    }
}
