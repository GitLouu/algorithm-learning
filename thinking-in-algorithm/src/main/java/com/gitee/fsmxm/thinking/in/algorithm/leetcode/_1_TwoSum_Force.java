package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * 难度 简单
 */
public class _1_TwoSum_Force {

    // 通过循环硬解法
    // T(n)=O(n^2)
    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 26);
        System.out.println(Arrays.toString(ints));
    }

}
