package com.gitee.fsmxm.thinking.in.algorithm.graph;

import java.util.ArrayList;

/**
 * 无向图
 */
public class Graph {

    /**
     * 邻接表
     */
    private final ArrayList<Integer>[] adj;

    /**
     * @param vertexNum 顶点个数
     */
    @SuppressWarnings("unchecked")
    public Graph(int vertexNum) {
        adj = new ArrayList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t) { // 无向图一边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getVertexNum() {
        return adj.length;
    }

    public ArrayList<Integer> get(int i) {
        return adj[i];
    }

}
