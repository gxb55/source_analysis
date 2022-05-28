package com.trip.algorithm.zuo.trainingcamp3.class03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 选择工作依赖排序
 * 每种工作有难度和报酬，规定如下
 * class Job {
 * public int money;// 该工作的报酬
 * public int hard; // 该工作的难度
 * }
 * 给定一个Job类型的数组jobarr，表示所有岗位，每个岗位都可以提供任意份工作
 * 选工作的标准是在难度不超过自身能力值的情况下，选择报酬最高的岗位
 * 给定一个int类型的数组arr，表示所有人的能力
 * 返回int类型的数组，表示每个人按照标准选工作后所能获得的最高报酬
 */
public class Code01_ChooseWork {
    public static void main(String[] args) {
        Job[] jobs = new Job[5];
        jobs[0] = new Job(1, 3);
        jobs[1] = new Job(1, 4);
        jobs[2] = new Job(3, 3);
        jobs[3] = new Job(3, 5);
        jobs[4] = new Job(4, 5);
        int[] arr = {1, 5, 6, 8};
        int[] moneys = getMoneys(jobs, arr);
        System.out.println(Arrays.toString(moneys));
    }

    public static int[] getMoneys(Job[] job, int[] ability) {
        if (job == null || job.length < 1) {
            return null;
        }
        Arrays.sort(job, new JobCompare());
        List<Job> list = new ArrayList<>();
        for (Job job1 : job) {
            if (list.size() == 0) {
                list.add(job1);
            } else {
                Job job2 = list.get(list.size() - 1);
                if (job2.hard == job1.hard) {
                    continue;
                } else if (job1.hard > job2.hard && job1.money <= job2.money) {
                    continue;

                }
                list.add(job1);
            }
        }
        int[] arr = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            arr[i] = getMaxMoney(ability[i], list);
        }
        return arr;
    }

    private static int getMaxMoney(int i, List<Job> list) {
        int result = -1;
        for (Job job : list) {
            if (job.hard <= i && result < job.money) {
                result = job.money;
            }
        }
        return result;
    }
}

class Job {
    public int hard;
    public int money;


    public Job(int hard, int money) {
        this.money = money;
        this.hard = hard;
    }

    @Override
    public String toString() {
        return "Job{" +
                "hard=" + hard +
                ", money=" + money +
                '}';
    }
}

class JobCompare implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.hard == o2.hard) {
            return o2.money - o1.money;
        }
        return o1.hard - o2.hard;
    }
}