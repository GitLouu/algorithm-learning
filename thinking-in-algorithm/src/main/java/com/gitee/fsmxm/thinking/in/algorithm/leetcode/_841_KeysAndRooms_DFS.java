package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 841. 钥匙和房间
 * https://leetcode-cn.com/problems/keys-and-rooms/
 * 难度 中等
 */
public class _841_KeysAndRooms_DFS {
    // 深度优先搜索
    // T(n) = O(n + m) n 是房间个数，m是房间里钥匙总数
    // S(n) = O(n)
    static class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            boolean[] opened = new boolean[rooms.size()];

            int[] count = new int[1];
            opened[0] = true;

            openRoom(0, rooms, opened, count);

            return count[0] == rooms.size();
        }

        private void openRoom(Integer key, List<List<Integer>> rooms, boolean[] opened, int[] count) {
            count[0]++;
            opened[key] = true;
            for (Integer k : rooms.get(key)) {
                if (!opened[k]) {
                    openRoom(k, rooms, opened, count);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1), Arrays.asList(2), Arrays.asList(3), Arrays.asList())));
        System.out.println(solution.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
    }
}
