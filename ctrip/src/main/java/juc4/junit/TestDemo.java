package juc4.junit;

public class TestDemo {
    public String scoreLevel(int score) {
        if (score <= 0) {
            return "缺考";
        } else if (score <= 60) {
            return "弱";
        } else if (score <= 70) {
            return "差";
        } else if (score <= 80) {
            return "中";
        } else if (score <=90) {
            return "良";
        } else {
            return "优";
        }
    }
}
