package com.trip.algorithm.leet.l24.l05;

/**
 * @author xbguo
 * @date 2024/5/9 18:28
 */
public class Solution2079 {

    public static void main(String[] args) {
        Solution2079 solution2079 = new Solution2079();
        int[] plants = {2, 2, 3, 3};
        int capacity = 5;
        int i = solution2079.wateringPlants(plants, capacity);
        System.out.println(i);
    }

    public int wateringPlants(int[] plants, int capacity) {
        Integer process = process(plants, capacity, capacity, 0);
        System.out.println(process );
        return process ;
    }

    /**
     * 走到植物 0 (1 步) ，浇水。水罐中还有 3 单位的水。
     * - 走到植物 1 (1 步) ，浇水。水罐中还有 1 单位的水。
     * - 由于不能完全浇灌植物 2 ，回到河边取水 (2 步)。
     * - 走到植物 2 (3 步) ，浇水。水罐中还有 2 单位的水。
     * - 由于不能完全浇灌植物 3 ，回到河边取水 (3 步)。
     * - 走到植物 3 (4 步) ，浇水。
     * 需要的步数是 = 1 + 1 + 2 + 3 + 3 + 4 = 14 。
     * @param plants
     * @param capacity
     * @param curCapacity
     * @param index
     * @return
     */

    private Integer process(int[] plants, int capacity, int curCapacity, int index) {
        if (index >= plants.length) {
            return 0;
        }
        int plant = plants[index];
        if (curCapacity >= plant) {
            return process(plants, capacity, curCapacity - plant, index + 1) + 1;
        } else {
            return process(plants, capacity, capacity - plant, index + 1) + index + (index + 1);
        }
    }

}
