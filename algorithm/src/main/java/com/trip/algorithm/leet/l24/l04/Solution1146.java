package com.trip.algorithm.leet.l24.l04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xbguo
 * @date 2024/4/30 15:24
 * @description TODO
 */
public class Solution1146 {

    public static void main(String[] args) {

    }

}

class SnapshotArray {

    Map<Integer, Integer>[] arr;
    int count;

    public SnapshotArray(int length) {
        arr = new HashMap[length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new HashMap<>();
            arr[i].put(0, 0);
        }
        count = 0;
    }

    public void set(int index, int val) {
        arr[index].put(count, val);
    }

    public int snap() {
        return count++;
    }

    public int get(int index, int snap_id) {
        int t = snap_id;
        while (null == arr[index].get(t)) {
            t--;
        }
        return arr[index].get(t);
    }
}

