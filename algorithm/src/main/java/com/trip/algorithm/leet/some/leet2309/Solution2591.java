package com.trip.algorithm.leet.some.leet2309;

/**
 * @author xbguo
 * @date 2023/9/22 16:10
 */
public class Solution2591 {
    public static void main(String[] args) {
        int money = 9;
        int children = 2;
        int i = distMoney(money, children);
        System.out.println(i);
    }

    public static int distMoney(int money, int children) {
        if (children > money) {
            return -1;
        } else if (children == money) {
            return 0;
        }
        int i = money / 8;
        if (i == 0) {
            return 0;
        }
        if (i == children) {
            if (money % 8 == 0) {
                return i;
            }
            return i - 1;
        } else if (i > children) {
            return children - 1;
        } else {
            while (true) {
                int t = i;
                int cur = t * 8;
                int res = money - cur;
                int resChildren = children - t;
                if (res > 0 && resChildren > 0 && res >= resChildren) {
                    if (resChildren == 1 && res == 4) {
                        return t - 1;
                    }
                    return t;
                } else {
                    i--;
                }
            }
        }
    }
}
