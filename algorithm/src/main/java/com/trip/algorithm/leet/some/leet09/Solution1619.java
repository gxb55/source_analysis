package com.trip.algorithm.leet.some.leet09;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * 输出：2.00000
 * 解释：删除数组中最大和最小的元素后，所有元素都等于 2，所以平均值为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * 输出：4.00000
 * 示例 3：
 * <p>
 * 输入：arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * 输出：4.77778
 * 示例 4：
 * <p>
 * 输入：arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
 * 输出：5.27778
 * 示例 5：
 * <p>
 * 输入：arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 * 输出：5.29167
 */
public class Solution1619 {
    public static void main(String[] args) {
        Solution1619 solution1619 = new Solution1619();
      //  int[] arr = {1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
      //  int[] arr = {6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
      //  int[] arr = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
        int[] arr = {9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3};
        double v = solution1619.trimMean(arr);
        System.out.println(v);
    }

    public double trimMean(int[] arr) {
        int length = arr.length;
        double v = length * 0.05;
        int len1 = (int) v;
        PriorityBlockingQueue<Integer> maxQueue = new PriorityBlockingQueue<Integer>(len1, (o1, o2) -> o1 - o2);
        PriorityBlockingQueue<Integer> minQueue = new PriorityBlockingQueue<Integer>(len1, (o1, o2) -> o2 - o1);
        int max = 0;
        for (int t : arr) {
            if(maxQueue.size()>=len1){
                if(maxQueue.peek()<t){
                    maxQueue.poll();
                    maxQueue.add(t);
                }
            }else{
                maxQueue.add(t);
            }

            if(minQueue.size()>=len1){
                if(minQueue.peek()>t){
                    minQueue.poll();
                    minQueue.add(t);
                }
            }else{
                minQueue.add(t);
            }
            max += t;
        }
        while (!maxQueue.isEmpty()) {
            max = max - maxQueue.poll();
        }
        while (!minQueue.isEmpty()) {
            max = max - minQueue.poll();
        }
        double v1 = max / (length - 2 * v);
        return v1;
    }
}
