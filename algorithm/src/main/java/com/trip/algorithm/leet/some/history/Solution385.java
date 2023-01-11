package com.trip.algorithm.leet.some.history;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution385 {
    public static void main(String[] args) {
        Solution385 solution385 = new Solution385();
        String s = "[123,[456,[789]]]";
        NestedInteger deserialize = solution385.deserialize(s);
        System.out.println(deserialize);
    }

    public NestedInteger deserialize(String s) {
        NestedInteger nestedInteger = new NestedIntegerImpl();
        if (s.indexOf("[") == -1) {
            nestedInteger.setInteger(Integer.valueOf(s));
            return nestedInteger;
        } else {
            String substring = s.substring(1, s.length() - 1);
            String[] split = substring.split(",");
            String s1 = split[0];
            nestedInteger.setInteger(Integer.valueOf(s1));
            process(s.substring(s1.length() + 2, s.length() - 1), nestedInteger, 0);
        }
        return nestedInteger;
    }

    private NestedInteger process(String s, NestedInteger result, int i) {
        NestedInteger nestedInteger = new NestedIntegerImpl();
        if (s.indexOf("[") == -1) {
            nestedInteger.add(new NestedIntegerImpl(Integer.valueOf(Integer.valueOf(s))));
            result.add(nestedInteger);
            return nestedInteger;
        }
        String substring = s.substring(i + 1, s.length() - 1);
        if (substring.indexOf("[") == -1) {
            nestedInteger.add(new NestedIntegerImpl(Integer.valueOf(Integer.valueOf(substring))));
            result.add(nestedInteger);
            return nestedInteger;
        }
        String[] split = substring.split(",");
        String s1 = split[0];
        nestedInteger.setInteger(Integer.valueOf(s1));
        result.add(nestedInteger);
        process(s.substring(s1.length() + 2, s.length() - 1), result, i);
        return nestedInteger;
    }
}

class NestedIntegerImpl implements NestedInteger {
    private Integer integer;
    private List<NestedInteger> list = new ArrayList<>();

    public NestedIntegerImpl(Integer integer) {
        this.integer = integer;
    }

    public NestedIntegerImpl() {
    }

    @Override
    public boolean isInteger() {
        return false;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public void setInteger(int value) {
        integer = value;
    }

    @Override
    public void add(NestedInteger ni) {
        list.add(ni);
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "NestedIntegerImpl{" +
                "integer=" + integer +
                ", list=" + list +
                '}';
    }
}