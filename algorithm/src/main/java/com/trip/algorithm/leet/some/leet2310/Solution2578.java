package com.trip.algorithm.leet.some.leet2310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xbguo
 * @date 2023/10/9 16:45
 * 19268
 */
public class Solution2578 {
    public static void main(String[] args) {
        Solution2578 solution2578 =new Solution2578();
        Integer num = 958351976;
        int i = solution2578.splitNum(num);
        System.out.println(i);
    }
    public  int splitNum(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<Integer> list0 = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i <chars.length; i++) {
            char aChar = chars[i];
            Integer x=Integer.valueOf(String.valueOf(aChar));
            if(list0.isEmpty()){
                list0.add(x);
            }else if(list1.isEmpty()){
                list1.add(x);
            }else if(list0.size()>list1.size()){
                list1.add(x);
            }else if(list1.size()>list0.size()){
                list0.add(x);
            }else if(list1.size()==list0.size()){
                Integer x0=getInteger(list0);
                Integer x1=getInteger(list1);
                if(x0>x1){
                    list1.add(x);
                }else{
                    list0.add(x);
                }
            }
        }

        Integer x=getInteger(list0);
        Integer y=getInteger(list1);
        return x+y;
    }
    public Integer getInteger(List<Integer> list1){
        StringBuilder stringBuilder0 =new StringBuilder();
        boolean flag =true;
        for (int x:list1){
            if(x==0&&flag){
                continue;
            }
            flag=false;
            stringBuilder0.append(x);
        }
        Integer x=0;
        if(stringBuilder0.length()>0){
            x=Integer.valueOf(stringBuilder0.toString());
        }
        return x;
    }
}
