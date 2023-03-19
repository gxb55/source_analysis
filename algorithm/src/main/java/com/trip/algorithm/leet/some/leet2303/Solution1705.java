package com.trip.algorithm.leet.some.leet2303;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/3/13 20:25
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 * <p>
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 * 示例 2:
 * <p>
 * 输入: ["A","A"]
 * <p>
 * 输出: []
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-longest-subarray-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1705 {
    public static void main(String[] args) {
       // String[] arr = {"A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"};
      //  String[] arr = {"A", "A"};
       // String[] arr = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] arr = {"42","10","O","t","y","p","g","B","96","H","5","v","P","52","25","96"
                ,"b","L","Y","z","d","52","3","v","71","J","A","0","v","51",
                "E","k","H","96","21","W","59","I","V","s","59","w","X","33","29","H","32",
                "51","f","i","58","56","66","90","F","10","93","53","85","28","78","d",
                "67","81","T","K","S","l","L","Z","j","5","R","b","44","R","h","B",
                "30","63","z","75","60","m","61","a","5"
                ,"S","Z","D","2","A","W","k","84","44","96","96","y","M"};
        String[] longestSubarray = findLongestSubarray(arr);
        for (String s : longestSubarray) {
            System.out.print(s+" ");
        }
    }

    public static String[] findLongestSubarray(String[] array) {
        int left = -1;
        int right = -1;
        int cur = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            String s = array[i];
            if ((s.compareTo("A") >= 0 && s.compareTo("Z") <= 0)||(s.compareTo("a") >= 0 && s.compareTo("z") <= 0)) {
                cur++;
            } else {
                cur--;
            }
            if (cur == 0 && (i + 1) > (right - left + 1)) {
                left = 0;
                right = i;
            }
            Integer integer = map.get(cur);
            if (integer != null && (i - integer) > (right - left + 1)) {
                left = integer+1;
                right = i;
            }
            if (!map.containsKey(cur)) {
                map.put(cur, i);
            }
        }
        if (left == -1 && right == -1) {
            return new String[0];
        }
        String[] res = new String[right - left + 1];
        int index=0;
        for (int i = left; i <= right; i++) {
            res[index++] = array[i];
        }
        return res;
    }
}
