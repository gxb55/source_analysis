package com.trip.algorithm.leet.some.leet2311;

/**
 * @author xbguo
 * @date 2023/11/8 19:14
 */
public class Solution2609 {
    public static void main(String[] args) {
       // String s = "01000111";
      //  String s = "00111";
       // String s = "111";
        String s = "001";
        int res = findTheLongestBalancedSubstring(s);
        System.out.println(res);
    }
    public static int findTheLongestBalancedSubstring(String s) {
        int length = s.length();
        int max=0;
        if(length==0){
            return 0;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if(ch=='1'){
                int left=i-1;
                int right=i;
                while (left>=0&&right<s.length()){
                    if(chars[left]=='0'&&chars[right]=='1'){
                        max=Math.max(max,right-left+1);
                        left--;
                        right++;
                    }else{
                        break;
                    }
                }
                i=right;

            }
        }
        return max;
    }
}
