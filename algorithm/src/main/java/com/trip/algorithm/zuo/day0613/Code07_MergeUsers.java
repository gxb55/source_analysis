package com.trip.algorithm.zuo.day0613;

import lombok.Data;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 */
public class Code07_MergeUsers {
    /**
     * 有很多的user user有三个元素，其中任意一对元素一样则认为是同一个元素，给一个list问你其中有多少个不重复的user
     * 举例 user1 a b c;user2 e b e;user3 e d d;则这三个属于同一个user
     */
    public int getUserNum(List<User> userList){
        Code01_UnionFind.UnionSet unionSet = new Code01_UnionFind.UnionSet(userList);
        HashMap<String,User> aMap = new HashMap<>();
        HashMap<String,User> bMap = new HashMap<>();
        HashMap<String,User> cMap = new HashMap<>();
        for (User user : userList){
            if(aMap.containsKey(user.a)){
                unionSet.union(user,aMap.get(user.a));
            }else{
                aMap.put(user.a,user);
            }

            if(bMap.containsKey(user.b)){
                unionSet.union(user,bMap.get(user.b));
            }else{
                bMap.put(user.b,user);
            }

            if(cMap.containsKey(user.c)){
                unionSet.union(user,cMap.get(user.c));
            }else{
                cMap.put(user.c,user);
            }
        }
        return unionSet.getSetNum();
    }
}

@Data
class User{
    String a;
    String b;
    String c;
}
