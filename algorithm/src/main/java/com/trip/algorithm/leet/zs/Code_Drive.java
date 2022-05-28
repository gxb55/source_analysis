package com.trip.algorithm.leet.zs;

/**
 * @author xbguo
 * @createTime 2022年04月16日 22:15:00
 * <p>
 * 现有司机n*2人，调度中心会将所有司机平分给A B两个区域
 * 第i个司机去A可得收入为income【i】【0】；
 * 第i个司机去B可得收入为income【i】【1】；
 * 返回所有调度方案中能够使所有司机总收入最高的方案是多少钱
 */
public class Code_Drive {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {3, 6}/*,
                {0, 9},
                {5, 6},
                {8, 6},
                {3, 9}*/
        };
        int i = Code_Drive.maxMoney(arr);
        System.out.println(i);
    }

    /**
     * 调度的线路
     *
     * @param income
     * @return
     */
    public static int maxMoney(int[][] income) {
        if (income == null || income.length == 1 || (income.length % 2) != 0) {
            return 0;
        }
        int res = income.length / 2;
        return process(income, 0, res);
    }

    /**
     * @param income 调度数组
     * @param index      下标
     * @param rest    分配去A区域的司机个数的剩余是多少；
     * @return
     */
    private static int process(int[][] income, int index, int rest) {
        if (index == income.length) {
            return 0;
        }
        // 还剩余res个A区域没有分配，下标距离结束也就剩余res个位置了，这个时候应该全部分配给A
        if (income.length - index == rest) {
            return process(income, index + 1, rest-1) + income[index][0];
        }
        // A 区域的司机全部分配完了，但是还有区域没有被分配，这个时候要分配B了
        if (rest == 0) {
            return process(income, index + 1, rest) + income[index][1];
        }
        int p1 = process(income, index + 1, rest) + income[index][1];
        int p2 = process(income, index + 1, rest-1) + income[index][0];
        return Math.max(p1, p2);
    }
}
