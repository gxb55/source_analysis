package com.trip.algorithm.zuo.day0914;

import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一个办公室多个会议
 * 如何安排最多的会议
 */
public class Code04_BestArrange {
    @Data
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 贪心算法，哪个结束的最早排序
     * 然后按照顺序来取
     * @param programs
     * @param timePoint
     * @return
     */
    public static int bestArrange(Program[] programs, int timePoint) {
        Arrays.sort(programs, Comparator.comparingInt(Program::getEnd));
        int index = 0;
        for (Program program : programs) {
            if (timePoint <= program.getStart()) {
                index++;
                timePoint = program.end;
            }
        }
        return index;
    }
}
