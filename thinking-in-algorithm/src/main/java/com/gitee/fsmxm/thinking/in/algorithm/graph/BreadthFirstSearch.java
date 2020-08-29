package com.gitee.fsmxm.thinking.in.algorithm.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索 BFS
 */
public class BreadthFirstSearch {
    /*
     *
     *  0 - 1 - 2
     *  |   |   |
     *  3 - 4 - 5
     *      |   |
     *      6 - 7
     *  首先，搜索 0       0 指向 1 和 3
     *  其次，搜索 1, 3    1 指向 2 和 4, 3 也指向 4, 但1已经搜索了，不需要重复搜索，下同
     *  再次，搜索 2, 4    2 指向 5, 4 指向 5 和 6
     *  再次，搜索 5, 6    5 指向 7, 6 指向 7
     *  最后，搜索 7
     */

    /**
     * 搜索一条从s到t的路径 （广度搜索得到的是最短路径）
     *
     * @param g 图
     * @param s s
     * @param t t
     */
    static void bfs(Graph g, int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[g.getVertexNum()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] prev = new int[g.getVertexNum()];
        Arrays.fill(prev, -1);

        boolean outFlag = false;
        while (!queue.isEmpty()) {
            Integer p = queue.poll();
            visited[p] = true;
            for (Integer q : g.get(p)) {
                if (!visited[q]) {
                    visited[q] = true;
                    prev[q] = p;
                    queue.add(q);
                    if (q == t) {
                        outFlag = true;
                        break;
                    }
                }
            }
            if (outFlag) {
                break;
            }
        }
        print(prev, s, t);
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
        bfs(graph, 0, 7);
    }
}
