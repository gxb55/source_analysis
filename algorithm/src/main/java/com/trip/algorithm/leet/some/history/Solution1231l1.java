package com.trip.algorithm.leet.some.history;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * @author xbguo 郭晓兵
 * @date 2020-12-31 14:06
 */
public class Solution1231l1 {
    /**
     * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 注意:
     *
     * 可以认为区间的终点总是大于它的起点。
     * 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
     * 示例 1:
     *
     * 输入: [ [1,2], [2,3], [3,4], [1,3] ]
     *
     * 输出: 1
     *
     * 解释: 移除 [1,3] 后，剩下的区间没有重叠。
     * 示例 2:
     *
     * 输入: [ [1,2], [1,2], [1,2] ]
     *
     * 输出: 2
     *
     * 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
     * 示例 3:
     *
     * 输入: [ [1,2], [2,3] ]
     *
     * 输出: 0
     *
     * 解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/non-overlapping-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args) {
        Solution1231l1 solution1231l1 = new Solution1231l1();
        int[][] intervals = new int[5][2];
        intervals[2] = new int[]{ -100,
                -87};
        intervals[1] = new int[]{-99,
                -44};
        intervals[0] = new int[]{ -98,
                -19};
        intervals[3] = new int[]{ -97,
                -33};
        intervals[4] = new int[]{ -96,
                -60};
        String str = "[[-100,-87],[-99,-44],[-98,-19],[-97,-33],[-96,-60],[-95,-17],[-94,-44],[-93,-9],[-92,-63],[-91,-76],[-90,-44],[-89,-18],[-88,10],[-87,-39],[-86,7],[-85,-76],[-84,-51],[-83,-48],[-82,-36],[-81,-63],[-80,-71],[-79,-4],[-78,-63],[-77,-14],[-76,-10],[-75,-36],[-74,31],[-73,11],[-72,-50],[-71,-30],[-70,33],[-69,-37],[-68,-50],[-67,6],[-66,-50],[-65,-26],[-64,21],[-63,-8],[-62,23],[-61,-34],[-60,13],[-59,19],[-58,41],[-57,-15],[-56,35],[-55,-4],[-54,-20],[-53,44],[-52,48],[-51,12],[-50,-43],[-49,10],[-48,-34],[-47,3],[-46,28],[-45,51],[-44,-14],[-43,59],[-42,-6],[-41,-32],[-40,-12],[-39,33],[-38,17],[-37,-7],[-36,-29],[-35,24],[-34,49],[-33,-19],[-32,2],[-31,8],[-30,74],[-29,58],[-28,13],[-27,-8],[-26,45],[-25,-5],[-24,45],[-23,19],[-22,9],[-21,54],[-20,1],[-19,81],[-18,17],[-17,-10],[-16,7],[-15,86],[-14,-3],[-13,-3],[-12,45],[-11,93],[-10,84],[-9,20],[-8,3],[-7,81],[-6,52],[-5,67],[-4,18],[-3,40],[-2,42],[-1,49],[0,7],[1,104],[2,79],[3,37],[4,47],[5,69],[6,89],[7,110],[8,108],[9,19],[10,25],[11,48],[12,63],[13,94],[14,55],[15,119],[16,64],[17,122],[18,92],[19,37],[20,86],[21,84],[22,122],[23,37],[24,125],[25,99],[26,45],[27,63],[28,40],[29,97],[30,78],[31,102],[32,120],[33,91],[34,107],[35,62],[36,137],[37,55],[38,115],[39,46],[40,136],[41,78],[42,86],[43,106],[44,66],[45,141],[46,92],[47,132],[48,89],[49,61],[50,128],[51,155],[52,153],[53,78],[54,114],[55,84],[56,151],[57,123],[58,69],[59,91],[60,89],[61,73],[62,81],[63,139],[64,108],[65,165],[66,92],[67,117],[68,140],[69,109],[70,102],[71,171],[72,141],[73,117],[74,124],[75,171],[76,132],[77,142],[78,107],[79,132],[80,171],[81,104],[82,160],[83,128],[84,137],[85,176],[86,188],[87,178],[88,117],[89,115],[90,140],[91,165],[92,133],[93,114],[94,125],[95,135],[96,144],[97,114],[98,183],[99,157]]";
        int[][] ints = JSONObject.parseObject(str, new TypeReference<int[][]>() { });
        int i = solution1231l1.eraseOverlapIntervals(intervals);
        System.out.println(i);

       /* int i1 = solution1231l1.eraseOverlapIntervals1(ints);
        System.out.println(i1);*/
    }

    public int eraseOverlapIntervals(int[][] intervals) {

        if(Objects.isNull(intervals) || intervals.length == 1){
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //升序排列
                if(o1[0] == o2[0]){
                    return o1[1] -o2[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        System.out.println(JSONObject.toJSONString(intervals));
        int count = 0;	//最多能组成的不重叠区间个数
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            /*if (end > intervals[i][0]  ) {
                continue;
            }
            end = intervals[i][1];
            count++;*/



            if ( end > intervals[i][0] ) {  // 当前的左边界小于右边界，说明需要删除，删除二者中右边界较大的那位，即更新右边界为二者中较小的。
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {  // 否则更新右边界为当前右边界
                end = intervals[i][1];
            }
        }
        return  count;
    }



    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });
        System.out.println(JSONObject.toJSONString(intervals));
        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        System.out.println("ans:"+ans);
        return n - ans;
    }

}
