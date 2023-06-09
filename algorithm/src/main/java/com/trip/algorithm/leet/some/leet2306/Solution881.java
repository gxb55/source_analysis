package com.trip.algorithm.leet.some.leet2306;

import java.util.Arrays;

/**
 * @author xbguo
 * @date 2023/6/7 19:17
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/boats-to-save-people
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution881 {
    public static void main(String[] args) {
       // int[] people = {3,5,3,4}; int limit = 5;
        int[] people = {3,2,2,1}; int limit = 3;
        int i = numRescueBoats(people,limit);
        System.out.println(i);
    }

    public static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int count=0;
        while (right >= left) {
            int leftVal = people[left];
            int rightVal = people[right];
            if((leftVal+rightVal)<=limit){
                left++;
                right--;
            }else{
                right--;
            }
            count++;
        }
        return count;
    }
}
