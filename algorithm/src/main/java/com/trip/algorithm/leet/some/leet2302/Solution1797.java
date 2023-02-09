package com.trip.algorithm.leet.some.leet2302;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2023/2/9 11:23
 * @description 1797
 */
public class Solution1797 {
    public static void main(String[] args) {
        System.out.println();
    }


}

class AuthenticationManager {
    Map<String, Auth> map = new HashMap<>();
    int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        Auth auth = new Auth(tokenId, currentTime, currentTime + timeToLive);
        map.put(tokenId, auth);
    }

    public void renew(String tokenId, int currentTime) {
        Auth auth = map.get(tokenId);
        if (auth!=null&&currentTime >= auth.begin && currentTime < auth.end) {
            auth.begin = currentTime;
            auth.end = currentTime + timeToLive;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Map.Entry<String, Auth> en : map.entrySet()) {
            Auth auth = en.getValue();
            if (currentTime >= auth.begin && currentTime < auth.end) {
                count++;
            }
        }
        return count;
    }
}

class Auth {
    public String name;
    public int begin;
    public int end;

    public Auth(String name, int begin, int end) {
        this.name = name;
        this.begin = begin;
        this.end = end;
    }
}