package com.trip.algorithm.leet.some.leet2312;

import java.util.*;

public class Solution2866 {
    public static void main(String[] args) {
        Solution2866 solution2866 = new Solution2866();
        // List<Integer> list = Arrays.asList(5, 3, 4, 1, 1);
        // List<Integer> list = Arrays.asList(1000000000, 1000000000, 1000000000);
       // List<Integer> list = Arrays.asList(999999998, 999999999, 1000000000);
        List<Integer> list = Arrays.asList(314324228,526196638,971780775,141382951,44825730,92939243,869702460,692214717,396184442,271863091,452818943,124554145,194393992,813279621,476977123,291285997,195696382,80619001,296691434,24194433,834306546,337273583,612960339,252148987,498162770,641751698,580675254,66186200,192009966,590634046,590252844,510204257,235020771,606202644,338253570,224352005,183647397,867961176,521468453,365745792,508222499,360685429,851354307,177768509,955097078,227459453,644376561,467834249,594236609,319781404,648225233,524439197,532203513,463002246,498592686,691351312,208635346,155682966,294639403,341617283,604365123,79112831,22440031,809193898,675993946,99928197,644324211,170555722,218906830,782039120,686747235,356537885);
        long l = solution2866.maximumSumOfHeights(list);
        System.out.println(l);
    }

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int len = maxHeights.size();
        long[] left = new long[maxHeights.size()];
        long[] right = new long[maxHeights.size()];
        Deque<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < maxHeights.size(); i++) {
            long val = maxHeights.get(i);
            while (!queue.isEmpty() && val < maxHeights.get(queue.peek())) {
                queue.poll();
            }
            if (queue.isEmpty()) {
                left[i] = (long) ((val) * (i + 1));
            } else {
                Integer peek = queue.peek();
                left[i] = (long) (left[peek] + (i - peek) * val);
            }
            queue.push(i);
        }
        long max = Math.max(left[len - 1], right[0]);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            long val = maxHeights.get(i);
            while (!list.isEmpty() && val < maxHeights.get(list.peekLast())) {
                list.pollLast();
            }
            if (list.isEmpty()) {
                right[i] = (long) (val*  (len - i));

            } else {
                Integer peek = list.peekLast();
                right[i] = right[peek] + (peek - i) * val;
            }
            list.addLast(i);
            max = Math.max(max, left[i] + right[i] - maxHeights.get(i));
        }

        return max;
    }
}
