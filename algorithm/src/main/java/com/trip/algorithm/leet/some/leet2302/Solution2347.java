package com.trip.algorithm.leet.some.leet2302;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author xbguo
 * @date 2023/2/20 17:13
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 *
 */
public class Solution2347 {
    public static void main(String[] args) {

    }

    public static String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>();
        for (char suit : suits) {
            set.add(suit);
        }
        if(set.size()==1){
            return "Flush";
        }
        boolean two=false;
        boolean there=false;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            int rank = ranks[i];
            if(map.containsKey(rank)){
                Integer integer = map.get(rank);
                map.put(rank,integer+1);
                if((integer+1)>=2){
                    two=true;
                }
                if((integer+1)>=3){
                    there=true;
                }
            }else{
                map.put(rank,1);
            }
        }
        if(there){
            return "Three of a Kind";
        }
        if(two){
            return "Pair";
        }

        return "High Card";
    }
}
