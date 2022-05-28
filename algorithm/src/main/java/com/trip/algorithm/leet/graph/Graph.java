package com.trip.algorithm.leet.graph;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    public HashSet<Edge> edges;
    public HashMap<Integer, Node> nodes;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashSet<Edge> edges) {
        this.edges = edges;
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }

    public void setNodes(HashMap<Integer, Node> nodes) {
        this.nodes = nodes;
    }
}
