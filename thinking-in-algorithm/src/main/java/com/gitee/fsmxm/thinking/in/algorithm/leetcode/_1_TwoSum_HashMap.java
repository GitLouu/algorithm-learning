package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * 难度 简单
 */
public class _1_TwoSum_HashMap {

    // 通过HashMap解法
    // T(n)=O(n)
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int res = target - nums[i];
                if (map.containsKey(res)) {
                    return new int[] {map.get(res), i};
                }
                map.put(nums[i], i);
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
