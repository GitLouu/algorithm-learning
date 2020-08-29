package com.gitee.fsmxm.thinking.in.algorithm.graph;

import java.util.Arrays;

/**
 * 深度优先搜索 DFS
 */
public class DepthFirstSearch {
    /*
     *
     *  0 - 1 - 2
     *  |   |   |
     *  3 - 4 - 5
     *      |   |
     *      6 - 7
     */

    /**
     * 搜索一条从s到t的路径 （广度搜索得到的是最短路径）
     *
     * @param g 图
     * @param s s
     * @param t t
     */
    static void dfs(Graph g, int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[g.getVertexNum()];

        int[] prev = new int[g.getVertexNum()];
        Arrays.fill(prev, -1);

        boolean[] found = new boolean[1];

        innerDfs(g, s, t, prev, visited, found);
        print(prev, s, t);
    }

    private static void innerDfs(Graph g, int s, int t, int[] prev, boolean[] visited, boolean[] found) {
        if (found[0]) {
            return;
        }
        visited[s] = true;
        if (s == t) {
            found[0] = true;
            return;
        }
        for (Integer q : g.get(s)) {
            if (!visited[q]) {
                prev[q] = s;
                innerDfs(g, q, t, prev, visited, found);
            }
        }
    }

    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + ", ");
    }


    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 7);
        dfs(graph, 3, 6);
    }
}
