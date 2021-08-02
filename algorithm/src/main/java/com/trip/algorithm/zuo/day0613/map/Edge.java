package com.trip.algorithm.zuo.day0613.map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge {
    /**
     * 边的权重
     */
    public int weight;
    /**
     * 边的出发点
     */
    public Node from;
    /**
     * 边的到达点
     */
    public Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "weight=" + weight +
                ", from=" + from +
                ", to=" + to +
                '}';
    }
}
