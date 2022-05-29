package com.trip.algorithm.leet.some;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @createTime 2022年05月29日 11:12:00
 * 860. 柠檬水找零
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * <p>
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * <p>
 * 注意，一开始你手头没有任何零钱。
 * <p>
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：bills = [5,5,5,10,20]
 * 输出：true
 * 解释：
 * 前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
 * 第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
 * 第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
 * 由于所有客户都得到了正确的找零，所以我们输出 true。
 * 示例 2：
 * <p>
 * 输入：bills = [5,5,10,10,20]
 * 输出：false
 * 解释：
 * 前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
 * 对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
 * 对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
 * 由于不是每位顾客都得到了正确的找零，所以答案是 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= bills.length <= 105
 * bills[i] 不是 5 就是 10 或是 20
 * 通过次数121,602提交次数207,680
 */
public class Solution860 {
    public static void main(String[] args) {
        Solution860 solution860 = new Solution860();
        //int[] bills = {5, 5, 5, 10, 20};
        int[] bills = {5,5,10,10,20};
        boolean b = solution860.lemonadeChange(bills);
        System.out.println(b);
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();
        //5 10 20
        for (int bill : bills) {
            int res = bill - 5;
            Integer integer = map.get(bill);
            if (res == 0) {
                if (integer == null) {
                    map.put(bill, 1);
                } else {
                    map.put(bill, integer + 1);
                }
            } else {
                while (res >= 10) {
                    Integer integer1 = map.get(10);
                    if (integer1 == null || integer1 == 0) {
                        break;
                    }
                    res = res - 10;
                    map.put(10, integer1 - 1);
                }


                while (res >= 5) {
                    Integer integer1 = map.get(5);
                    if (integer1 == null || integer1 == 0) {
                        break;
                    }
                    res = res - 5;
                    map.put(5, integer1 - 1);
                }
                if (res != 0) {
                    return false;
                }
                if (integer == null) {
                    map.put(bill, 1);
                } else {
                    map.put(bill, integer + 1);
                }
            }
        }
        return true;
    }
}
