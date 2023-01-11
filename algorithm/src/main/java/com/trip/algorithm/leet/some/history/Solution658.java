package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2022/6/15  18:49
 * @description 658
 * 658. 找到 K 个最接近的元素
 * 给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。
 * <p>
 * 整数 a 比整数 b 更接近 x 需要满足：
 * <p>
 * |a - x| < |b - x| 或者
 * |a - x| == |b - x| 且 a < b
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = 3
 * 输出：[1,2,3,4]
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 4, x = -1
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= arr.length
 * 1 <= arr.length <= 104
 * arr 按 升序 排列
 * -104 <= arr[i], x <= 104
 * 通过次数40,618提交次数88,643
 */
public class Solution658 {
    public static void main(String[] args) {
        Solution658 solution658 = new Solution658();
      /*  int[] arr = {1, 2, 3, 4, 5};
        int k = 4, x = 3;*/

       /* int[] arr = {1,1,1,10,10,10};
        int k = 1, x = 9; */

      /*  int[] arr = {-2,-1,1,2,3,4,5};
        int k = 7, x = 3;*/

        int[] arr = {3,5,8,10};
        int k = 2, x = 15;


        List<Integer> closestElements = solution658.findClosestElements(arr, k, x);
        System.out.println(closestElements);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr[mid];
            if(left>right){
                break;
            }
            if (midVal == x) {
                index = mid;
                break;
            }
            if ((mid + 1)<arr.length&&midVal < x && arr[mid + 1] > x ) {
                if(Math.abs(midVal-x)>=Math.abs(arr[mid+1]-x)){
                    index = mid+1;
                }else{
                    index=mid;
                }
                break;
            }
            if (midVal < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (index == -1 && right == -1) {
            index = 0;
        } else if (index == -1 && left == arr.length) {
            index = arr.length - 1;
        }
        List<Integer> list = new ArrayList<>();
        int l = index - 1;
        int r = index;
        while (k > 0) {
            if (l >= 0 && r < arr.length) {
                int lVal = arr[l];
                int rVal = arr[r];
                if (Math.abs(lVal - x) > Math.abs(rVal - x)) {
                    list.add(rVal);
                    r++;
                } else {
                    list.add(lVal);
                    l--;
                }
            } else if (l < 0 && r < arr.length) {
                int rVal = arr[r];
                list.add(rVal);
                r++;
            } else if (r >= 0 && r >= arr.length) {
                int lVal = arr[l];
                list.add(lVal);
                l--;
            }
            k--;
        }
        List<Integer> collect = list.stream().sorted(Integer::compareTo).collect(Collectors.toList());
        return collect;
    }
}
