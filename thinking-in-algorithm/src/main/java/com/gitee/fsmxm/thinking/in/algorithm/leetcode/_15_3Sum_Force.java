package com.gitee.fsmxm.thinking.in.algorithm.leetcode;

import java.util.*;

/**
 * 15. 三数之和
 * https://leetcode-cn.com/problems/3sum/
 * 难度 中等
 */
public class _15_3Sum_Force {
    // T(n)=O(n^3)
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
    }
}
