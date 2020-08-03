package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯问题
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 难度 简单
 */
public class _70_ClimbingStairs_Recursion {

    // 使用递归解决
    static class Solution {

        // 记录计算结果，避免重复计算
        Map<Integer, Integer> record = new HashMap<Integer, Integer>();

        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }

            if (n == 2) {
                return 2;
            }

            if (record.containsKey(n)) {
                return record.get(n);
            }

            int sum = climbStairs(n - 1) + climbStairs(n - 2);
            record.put(n, sum);
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
