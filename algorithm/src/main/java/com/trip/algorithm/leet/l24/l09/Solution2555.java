package com.trip.algorithm.leet.l24.l09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xbguo
 * @date 2024/9/11 19:20
 */
public class Solution2555 {
    public static void main(String[] args) {
        // int[] arr = {1, 1, 2, 2, 3, 3, 5};
        // int k = 2;
      /*  int[] arr = {2616,2618,2620,2621,2626,2635,2657,2662,2662,2669,2671,2693,2702,2713,2714,2718,2730,2731,2750,2756,2772,2773,2775,2785,2795,2805,2811,2813,2816,2823,2824,2824,2826,2830,2833,2857,2885,2898,2910,2919,2928,2941,2942,2944,2965,2967,2970,2973,2974,2975,2977,3002,3007,3012,3042,3049,3078,3084,3089,3090,3094,3097,3114,3124,3125,3125,3144,3147,3148,3174,3197,3255,3262,3288,3291,3316,3320,3322,3331,3342,3378,3412,3412,3416,3420,3427,3428,3446,3452,3472,3479,3483,3488,3500,3516,3522,3531,3532,3540,3540,3544,3557,3570,3580,3592,3597,3597,3601,3615,3631,3640,3645,3673,3677,3681,3683,3685,3718,3738,3746,3758,3769,3797,3802,3815,3832,3839,3851,3864,3888,3889,3901,3902,3910,3913,3933,3940,3961,3974,3988,4003,4013,4019,4023,4026,4047,4060,4065,4072,4073,4082,4084,4109,4132,4139,4143,4145,4146,4155};
        int k = 6641;    */
        int[] arr = {3937, 3938, 3939, 3951, 3951, 3959, 3975, 3988, 3993, 4010, 4031, 4033, 4036, 4038, 4039, 4041, 4047, 4058, 4059, 4064, 4072, 4081, 4084, 4084, 4089, 4094, 4098, 4112, 4114, 4116, 4123, 4123, 4127, 4130, 4135, 4143, 4149, 4152, 4163, 4164, 4176, 4178, 4180, 4198, 4216, 4224, 4233, 4240, 4253, 4259, 4273, 4286, 4305, 4322, 4335, 4350, 4364, 4378, 4396, 4397, 4398, 4404, 4415, 4421, 4430, 4469, 4476, 4490, 4492, 4497, 4504, 4519, 4519, 4525, 4526, 4530, 4530, 4540, 4550, 4554, 4563, 4571, 4571, 4595, 4595, 4606, 4639, 4639, 4660, 4663, 4676, 4678, 4680, 4695, 4697, 4709, 4709, 4711, 4724, 4751, 4781, 4786, 4786, 4794, 4797, 4801, 4807, 4808, 4817, 4822, 4824, 4825, 4840, 4851, 4887, 4889, 4891, 4910, 4917, 4927, 4931, 4932, 4951, 4959, 4964, 4993, 4997, 5003, 5003, 5006, 5006, 5022, 5029, 5035, 5043, 5045, 5045, 5046, 5059, 5060, 5079, 5084, 5105, 5109, 5109, 5112, 5120, 5126, 5130, 5142, 5143, 5151, 5152, 5154, 5156, 5168, 5189, 5213, 5214, 5223, 5226, 5235, 5247, 5259, 5272, 5289, 5303, 5309, 5317, 5322, 5344, 5347, 5352, 5374, 5379, 5380, 5383, 5385, 5391, 5418, 5425, 5429, 5432, 5479, 5486, 5490, 5502, 5502, 5505, 5506, 5509, 5515, 5518, 5519, 5521, 5526, 5528, 5533, 5536, 5536, 5538, 5555, 5556, 5557, 5557, 5566, 5571, 5580, 5585, 5596, 5604, 5619, 5634, 5649, 5668, 5694, 5696, 5699, 5701, 5704, 5709, 5732, 5745, 5745, 5746, 5749, 5762, 5766, 5766, 5770, 5773, 5796, 5810, 5817, 5823, 5838, 5843, 5846, 5860, 5869, 5872, 5877, 5880, 5896, 5899, 5902, 5905, 5910, 5913, 5913, 5915, 5923};
        int k = 220;
        int i = maximizeWin1(arr, k);
        System.out.println(i);
    }

    public static int maximizeWin1(int[] prizePositions, int k) {
        int[] dp = new int[prizePositions.length + 1];
        int l = 0;
        int max = 0;
        for (int i = 0; i < prizePositions.length; i++) {
            while (prizePositions[i] - prizePositions[l] > k) {
                l++;
            }

            max = Math.max(max, (i - l+1) + dp[l]);
            dp[i+1] = Math.max(dp[i ], (i - l+1));

        }
        return max;
    }

    public static int maximizeWin(int[] prizePositions, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : prizePositions) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> collect1 = Arrays.stream(prizePositions).boxed().distinct().collect(Collectors.toList());
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((x, y) -> x.getKey() - y.getKey()).collect(Collectors.toList());
        // 从x到y 值是z
        List<int[]> list = new ArrayList<>();
        int l = -1;
        int r = -1;
        int s = 0;
        for (int i = 0; i < collect.size(); i++) {
            Map.Entry<Integer, Integer> entry = collect.get(i);
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (l == -1) {
                s = s + value;
                l = key;
                r = key;
            } else {
                //超过范围
                if ((key - l) > k) {
                    list.add(new int[]{l, r, s});
                    while ((key - l) > k) {
                        s = s - map.get(l);
                        int i1 = collect1.indexOf(l);
                        l = collect1.get(i1 + 1);
                    }
                    r = key;
                    s = s + value;
                } else {
                    r = key;
                    s = s + value;
                }
            }
        }

        list.add(new int[]{l, r, s});
        if (list.size() == 1) {
            return list.get(0)[2];
        }
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int[] ints1 = list.get(j);
                if (ints1[0] > ints[1]) {
                    max = Math.max(max, ints[2] + ints1[2]);
                } else {
                    int sum = ints[2] + ints1[2];
                    Integer l1 = collect1.indexOf(ints1[0]);
                    Integer r1 = collect1.indexOf(ints[1]);
                    for (int m = l1; m <= r1; m++) {
                        sum -= map.get(collect1.get(m));
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        return max;
    }
}
