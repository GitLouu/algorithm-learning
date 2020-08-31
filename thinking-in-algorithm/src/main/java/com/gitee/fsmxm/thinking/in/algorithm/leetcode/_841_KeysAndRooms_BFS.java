package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 * 难度 中等
 */
public class _841_KeysAndRooms_BFS {
    // 广度优先搜索
    // T(n) = O(n + m) n 是房间个数，m是房间里钥匙总数
    // S(n) = O(n)
    static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] haveKeys = new boolean[rooms.size()];

            Queue<Integer> keyQueue = new LinkedList<>();
            keyQueue.add(0);
            haveKeys[0] = true;

            int count = 0;
            while (!keyQueue.isEmpty()) {
                Integer k = keyQueue.poll();
                count++;
                for (Integer key : rooms.get(k)) {
                    if (!haveKeys[key]) {
                        haveKeys[key] = true;
                        keyQueue.add(key);
                    }
                }
            }
            return count == rooms.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        System.out.println(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
    }
}
