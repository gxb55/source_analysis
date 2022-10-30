package com.trip.algorithm.leet.some.greedy;

/**
 * @author xbguo
 * @createTime 2022年07月17日 11:57:00
 * 553. 最优除法
 * 给定一组正整数，相邻的整数之间将会进行浮点除法操作。例如， [2,3,4] -> 2 / 3 / 4 。
 * <p>
 * 但是，你可以在任意位置添加任意数目的括号，来改变算数的优先级。你需要找出怎么添加括号，才能得到最大的结果，并且返回相应的字符串格式的表达式。你的表达式不应该含有冗余的括号。
 * <p>
 * 示例：
 * <p>
 * 输入: [1000,100,10,2]
 * 输出: "1000/(100/10/2)"
 * 解释:
 * 1000/(100/10/2) = 1000/((100/10)/2) = 200
 * 但是，以下加粗的括号 "1000/((100/10)/2)" 是冗余的，
 * 因为他们并不影响操作的优先级，所以你需要返回 "1000/(100/10/2)"。
 * <p>
 * 其他用例:
 * 1000/(100/10)/2 = 50
 * 1000/(100/(10/2)) = 50
 * 1000/100/10/2 = 0.5
 * 1000/100/(10/2) = 2
 * 说明:
 * <p>
 * 输入数组的长度在 [1, 10] 之间。
 * 数组中每个元素的大小都在 [2, 1000] 之间。
 * 每个测试用例只有一个最优除法解。
 * 通过次数29,106提交次数44,838
 * <p>
 * 1000/(100/10/2)
 */
public class Solution553 {
    public static void main(String[] args) {
        Solution553 solution553 = new Solution553();
        int[] arr={1000,100,10,2};
        String s = solution553.optimalDivision(arr);
        System.out.println(s);

    }

    public String optimalDivision(int[] nums) {
        StringBuilder stringBuilder = new StringBuilder();
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        } else if (nums.length == 2) {
            stringBuilder.append(nums[0]).append("/").append(nums[1]);
            return stringBuilder.toString();
        } else {
            stringBuilder.append(nums[0]).append("/(").append(nums[1]);
            for (int i = 2; i < nums.length; i++) {
                stringBuilder.append("/" + nums[i]);
            }
            stringBuilder.append(")");
        }
        return stringBuilder.toString();
    }
}
