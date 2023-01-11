package com.trip.algorithm.leet.some.leet08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xbguo
 * @date 2022/8/19  17:16
 * @description TODO
 */
public class Solution30 {
    public static void main(String[] args) {

    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int length = words[0].length();
        int sum = length * words.length;
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int left=0;
        int right=0;
        int i=0;
        int count=length;

        /*while (true){
            for ( ; i <s.length() &&count>=0; i++,count--) {
                stringBuilder.append(s.charAt(i));
                right++;
            }
            String s1 = stringBuilder.toString();
            if(map.containsKey(s1)&& map.get(s1)>1){
                map.put(s1,map.get(s1)-1);
                if((right-left)==sum){
                    list.add(left);
                }
            }else{

            }
        }
*/


        return null;
    }
}
