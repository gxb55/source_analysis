package com.trip.algorithm.zuo.day0613.map;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * node 表示点
 *
 * @author Administrator
 */
@Getter
@Setter
public class Node {
    /**
     * 这个点代表的值比如代表A代表1
     */
    public int value;
    /**
     * 多少个点直接指向他
     */
    public int in;
    /**
     * 他直接指向多少个点
     */
    public int out;
    /**
     * 他指向的点的集合
     */
    public ArrayList<Node> nexts;
    /**
     * 他直接指向的边的集合
     */
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value && in == node.in && out == node.out;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, in, out);
    }
}
