package com.trip.algorithm.zuo.day0613.map;

import java.util.Comparator;

/**
 * @author Administrator
 */
public class Edge_Compare implements Comparator<Edge> {

    @Override
    public int compare(Edge o1, Edge o2) {
        return o1.getWeight()-o2.getWeight();
    }
}
