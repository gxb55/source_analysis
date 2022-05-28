package com.trip.algorithm.leet.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Node {
    /**
     * 指向他的点有多少个
     */
    public Integer in;
    /**
     * 他指向别人的点有多少个
     */
    public Integer out;
    /**
     * 点的值
     */
    public Integer value;
    /**
     * 点指向的点有哪些
     */
    public List<Node> nexts;
    /**
     * 这个点指出去的边
     */
    public List<Edge> edges;

    public Node(Integer value) {
        this.value = value;
        in=0;
        out=0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
