package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xbguo 郭晓兵
 * @date 2020-11-12 19:28
 */
public class Solution1112l2 {
    public static void main(String[] args) {
        Solution1112l2 solution1112l2 = new Solution1112l2();
        int i = solution1112l2.lengthOfLongestSubstring("dvdf");
        System.out.println(i);

    }
    public int lengthOfLongestSubstring(String s) {
        int a=-1;
        List<String> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            String str = s.substring(i,i+1);
            if(!list.contains(str)){
                list.add(str);
            }else{
                i=i-list.size()+1;
                a=Math.max(list.size(),a);
                str = s.substring(i,i+1);
                list.clear();
                list.add(str);
            }
        }
        return Math.max(a,list.size());
    }

}
