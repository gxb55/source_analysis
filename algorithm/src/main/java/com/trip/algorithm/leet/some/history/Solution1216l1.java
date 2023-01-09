package com.trip.algorithm.leet.some.history;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-16 17:46
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
 *
 * 通过次数54,770提交次数120,630
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-pattern
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1216l1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(2);
        System.out.println(list.indexOf(1));
        Solution1216l1 solution1216l1 = new Solution1216l1();
        boolean b = solution1216l1.wordPattern("abba","dog cat cat dog");
        System.out.println(b);
    }
    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] s1 = s.split(" ");
        if(chars.length != s1.length){
            return false;
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        int a ,b ;
        for(a=0;a<chars.length;a++){
            for(b=a+1;b<chars.length;b++){
                if(chars[a] == chars[b]){
                    sb.append(b);
                }
            }

           String result =  get(a,s1);
           if(!result.equals(sb.toString())){
               flag = false;
               break;
           }
            sb = new StringBuilder();
        }

       return flag;
    }

    private String get(int a, String[] s1) {
        String str="";
        String s = s1[a];
        for(int i=a+1;i<s1.length;i++){
            if(Objects.equals(s,s1[i])){
                str =str+i;
            }
        }
        return str;
    }
}
