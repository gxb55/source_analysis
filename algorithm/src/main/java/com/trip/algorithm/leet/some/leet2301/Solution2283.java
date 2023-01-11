package com.trip.algorithm.leet.some.leet2301;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/1/11 09:39
 * @description Solution2283
 * 2283. 判断一个数的数字计数是否等于数位的值
 * 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。
 * <p>
 * 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "1210"
 * 输出：true
 * 解释：
 * num[0] = '1' 。数字 0 在 num 中出现了一次。
 * num[1] = '2' 。数字 1 在 num 中出现了两次。
 * num[2] = '1' 。数字 2 在 num 中出现了一次。
 * num[3] = '0' 。数字 3 在 num 中出现了零次。
 * "1210" 满足题目要求条件，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：num = "030"
 * 输出：false
 * 解释：
 * num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了一次。
 * num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
 * num[2] = '0' 。数字 2 在 num 中出现了 0 次。
 * 下标 0 和 1 都违反了题目要求，所以返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == num.length
 * 1 <= n <= 10
 * num 只包含数字。
 * 通过次数11,654提交次数14,546
 */
public class Solution2283 {
    public static void main(String[] args) {
        Solution2283 solution2283 = new Solution2283();
       // String num = "1210";
        String num = "030";
        boolean b = solution2283.digitCount(num);
        System.out.println(b);
    }

    public boolean digitCount(String num) {
        char[] chars = num.toCharArray();
        Map<Integer,Integer> map = new HashMap<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            int val = chars[i] - '0';
            if(map.containsKey(val)){
                map.put(val,map.get(val)+1);
            }else{
                map.put(val,1);
            }
            if(val!=0){
                map1.put(i,val);
            }

        }
        if(map.size()!=map1.size()){
            return false;
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            Integer integer = map1.get(key);
            if(integer==null||!integer.equals(value)){
                return false;
            }
        }
        return true;
    }
}
