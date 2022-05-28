package com.trip.algorithm.leet.graph;

import lombok.Getter;
import lombok.Setter;

/**
 * 边类
 *
 * @author Administrator
 */

public class Edge {
    /**
     * 出发 点
     */
    public Node from;
    /**
     * 到达 点
     */
    public Node to;
    /**
     * 边的权重
     */
    public Integer weight;

    public Edge(Node from, Node to, Integer weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}
