package com.trip.algorithm.leet.some.leet2302;

import java.util.PriorityQueue;

/**
 * @author xbguo
 * @createTime 2023年02月20日 08:21:00
 */
public class Solution1792 {
    public static void main(String[] args) {
       int[][] classes = {{1,2},{3,5},{2,2}}; int extraStudents = 2;
        double v = Solution1792.maxAverageRatio(classes, extraStudents);
        System.out.println(v);
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x,y)-> (int) (Double.parseDouble(classes[x][0]+"")/classes[x][1] - Double.parseDouble(classes[y][0]+"")/classes[y][1]));
        int length = classes.length;
        for (int i = 0; i < length; i++) {
            priorityQueue.add(i);
        }
        while (extraStudents!=0){
            Integer poll = priorityQueue.poll();
            classes[poll][0]++;
            classes[poll][1]++;
            priorityQueue.add(poll);
            extraStudents--;
        }
        double res=0;
        for (int i = 0; i < length; i++) {
            double i1 = Double.parseDouble(classes[i][0]+"") / classes[i][1];
            res=res+i1;
        }
        res=res/length;
        return res;
    }

}
