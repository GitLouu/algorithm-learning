package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

/**
 * 657. 机器人能否返回原点
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 * 难度 简单
 */
public class _657_RobotReturnToOrigin_Simulator {
    // 模拟法
    // 向左次数等于向右次数 且 向上次数等于向下次数  则回到原点
    // T(n) = O(n)
    // S(n) = O(n)
    static class Solution {
        public boolean judgeCircle(String moves) {
            if (moves == null || moves.length() < 1) {
                return true;
            }
            int x = 0, y = 0;
            char[] chars = moves.toCharArray();
            for (char c : chars) {
                if (c == 'R') {
                    x++;
                } else if (c == 'L') {
                    x--;
                } else if (c == 'U') {
                    y++;
                } else if (c == 'D') {
                    y--;
                }
            }
            return x == 0 && y == 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.judgeCircle("UD"));
        System.out.println(solution.judgeCircle("LL"));
    }
}
