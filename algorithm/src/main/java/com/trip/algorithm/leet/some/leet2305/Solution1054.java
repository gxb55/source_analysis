package com.trip.algorithm.leet.some.leet2305;

import java.util.*;

/**
 * @author xbguo
 * @createTime 2023年05月14日 20:56:00
 * 示例 1：
 *
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 *
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/distant-barcodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1054 {
    public static void main(String[] args) {
      //  int[] barcodes = {1,1,1,2,2,2};
      //  int[] barcodes = {1,1,1,1,2,2,3,3};
        int[] barcodes = {1,1,1,1,2,2,3,3,4};
       // int[] barcodes = {2,2,1,3};
        int[] ints = rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int x:barcodes){
             map.put(x,map.getOrDefault(x,0)+1);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        map.entrySet().forEach(x->{
            queue.add(new int[]{x.getValue(),x.getKey()});
        });
        int[] arr = new int[barcodes.length];
        int index = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if(queue.size()==0){
                arr[index++]=poll[1];
                break;
            }
            int[] poll1 = queue.poll();
            arr[index++]=poll[1];
            arr[index++]=poll1[1];
            if(poll[0]>1){
                queue.add(new int[]{poll[0]-1,poll[1]});
            }
            if(poll1[0]>1){
                queue.add(new int[]{poll1[0]-1,poll1[1]});
            }
        }
        return arr;
    }
}
