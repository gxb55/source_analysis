package com.trip.algorithm.leet.l24.l07;

import java.util.ArrayList;
import java.util.List;

public class Solution682 {
    public static void main(String[] args) {

    }

    public int calPoints(String[] operations) {
        List<Integer> list = new ArrayList<>();

        for (String a : operations) {
            if(a.equals("+")){
                Integer i1 = list.get(list.size() - 1);
                Integer i2 = list.get(list.size() - 2);
                list.add(i1+i2);
            }else if(a.equals("D")){
                Integer i1 = list.get(list.size() - 1);
                list.add(2*i1);
            }else if(a.equals("C")){
                list.remove(list.size() - 1);
            }else {
                list.add(Integer.valueOf(a));
            }
        }
        return list.stream().reduce(0, (x, y) -> x + y);
    }
}
