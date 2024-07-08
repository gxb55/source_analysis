package com.trip.algorithm.leet.l24.l07;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/7/5 09:38
 */
public class Test {
    public static void main(String[] args) {
        Map<String,String> map =null;
        try {
            map=new HashMap<>();
            map.put("1","1");
            throw new Exception();
        }catch (Exception e){
            System.out.println(map);
        }finally {
            System.out.println(map);
        }
    }
}
