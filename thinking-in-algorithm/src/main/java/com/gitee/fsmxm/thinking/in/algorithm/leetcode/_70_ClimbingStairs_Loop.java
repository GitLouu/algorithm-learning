package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯问题
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 难度 简单
 */
public class _70_ClimbingStairs_Loop {

    // 使用循环解决 （斐波那契数列问题）
    static class Solution {

        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int sum = 0;
            for (int i = 3, step1 = 1, step2 = 2; i <= n; i++) {
                sum = step1 + step2;
                step1 = step2;
                step2 = sum;
            }
            return sum;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(1));
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));
    }

}
