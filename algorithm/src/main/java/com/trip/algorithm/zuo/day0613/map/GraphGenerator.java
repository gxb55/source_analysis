package com.trip.algorithm.zuo.day0613.map;

public class GraphGenerator {
    /**
     * n*3的二位数组
     * 【权重，from，to】
     * 1,1,2
     * 1,2，3
     * 1,3,4
     * 1,1,5
     * 1,5,3
     * 1,3,6
     * 转化为我们提前设计好的图
     * @param matrix
     * @return
     */
    public static Graph createGraph(Integer[][] matrix){
        Graph graph = new Graph();
        for (int i = 0; i < matrix.length; i++) {
            Integer weight = matrix[i][0];
            Integer from = matrix[i][1];
            Integer to = matrix[i][2];
            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            // 两个点
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            // 一条线
            Edge edge = new Edge(weight,fromNode,toNode);
            // 设置点的属性
            toNode.in++;

            fromNode.out++;
            fromNode.nexts.add(toNode);
            fromNode.edges.add(edge);
            //图的边
            graph.edges.add(edge);
        }
        return graph;
    }
}
